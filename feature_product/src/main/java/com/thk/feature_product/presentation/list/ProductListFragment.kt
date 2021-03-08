package com.thk.feature_product.presentation.list

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.thk.feature_product.R
import com.thk.feature_product.databinding.FragmentProductListBinding
import com.thk.feature_product.presentation.list.recyclerview.GridAutoFitLayoutManager
import com.thk.feature_product.presentation.list.recyclerview.CategoryRecyclerViewAdapter
import com.thk.menu.base.delegate.viewBinding
import com.thk.menu.base.presentation.extension.observe
import com.thk.menu.base.presentation.extension.visible
import com.thk.menu.base.presentation.fragment.InjectionFragment
import org.kodein.di.generic.instance

class ProductListFragment : InjectionFragment(R.layout.fragment_product_list) {

    private val binding: FragmentProductListBinding by viewBinding()

    private val viewModel: ProductListViewModel by instance()

    private val categoryAdapter: CategoryRecyclerViewAdapter by instance()

    private val stateObserver = Observer<ProductListViewModel.ViewState> {
        categoryAdapter.categories = it.categories

        binding.progressBar.visible = it.isLoading
        binding.errorAnimation.visible = it.isError
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val context = requireContext()

        categoryAdapter.setOnDebouncedClickListener {
            viewModel.navigateToProductDetails(it)
        }

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = categoryAdapter
        }

        observe(viewModel.stateLiveData, stateObserver)

        viewModel.loadData()
    }
}
