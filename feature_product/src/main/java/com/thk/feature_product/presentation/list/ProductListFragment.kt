package com.thk.feature_product.presentation.list

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.thk.feature_product.R
import com.thk.feature_product.databinding.FragmentProductListBinding
import com.thk.menu.base.delegate.viewBinding
import com.thk.menu.base.presentation.extension.observe
import com.thk.menu.base.presentation.fragment.InjectionFragment
import org.kodein.di.generic.instance

/**
 * A fragment representing a list of Items.
 */
class ProductListFragment : InjectionFragment(R.layout.fragment_product_list) {

    private val binding: FragmentProductListBinding by viewBinding()

    private val viewModel: ProductListViewModel by instance()

    private val productAdapter: ProductRecyclerViewAdapter by instance()

    private val stateObserver = Observer<ProductListViewModel.ViewState> {
        val categories = it.categories
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observe(viewModel.stateLiveData, stateObserver)

        viewModel.loadData()
    }

    companion object {

        @JvmStatic
        fun newInstance() = ProductListFragment()
    }
}
