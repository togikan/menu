package com.thk.feature_product.presentation.list

import android.os.Bundle
import android.view.View
import androidx.core.view.doOnPreDraw
import androidx.lifecycle.Observer
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.LinearLayoutManager
import com.thk.feature_product.R
import com.thk.feature_product.databinding.FragmentProductListBinding
import com.thk.feature_product.presentation.list.recyclerview.CategoryRecyclerViewAdapter
import com.thk.feature_product.test.EspressoIdlingResource
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
        EspressoIdlingResource.decrement()

        binding.progressBar.visible = it.isLoading
        binding.errorAnimation.visible = it.isError
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setItemClickListener()
        setEnterTransition(view)
        setupList()

        observe(viewModel.stateLiveData, stateObserver)

        if (viewModel.stateLiveData.value?.categories == null) {
            binding.progressBar.visible()
            EspressoIdlingResource.increment()
            viewModel.loadData()
        }
    }

    private fun setEnterTransition(view: View) {
        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }
    }

    private fun setItemClickListener() {
        categoryAdapter.setOnDebouncedClickListener { product, view ->
            val extras: FragmentNavigator.Extras = FragmentNavigatorExtras(view to product.name)
            viewModel.navigateToProductDetails(product, extras)
        }
    }

    private fun setupList() {
        val context = requireContext()
        binding.recyclerViewCategory.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = categoryAdapter
        }
    }
}
