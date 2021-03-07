package com.thk.feature_product.presentation.list

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.thk.feature_product.R
import com.thk.feature_product.databinding.FragmentMenuItemListBinding
import com.thk.menu.base.delegate.viewBinding
import com.thk.menu.base.presentation.extension.observe
import com.thk.menu.base.presentation.fragment.InjectionFragment
import org.kodein.di.generic.instance

/**
 * A fragment representing a list of Items.
 */
class ItemListFragment : InjectionFragment(R.layout.fragment_menu_item_list) {

    private val binding: FragmentMenuItemListBinding by viewBinding()

    private val viewModel: ProductListViewModel by instance()

    private val itemAdapter: ItemRecyclerViewAdapter by instance()

    private var columnCount = 1

    private val stateObserver = Observer<ProductListViewModel.ViewState> {
        val categories = it.categories
//
//        binding.progressBar.visible = it.isLoading
//        binding.errorAnimation.visible = it.isError
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observe(viewModel.stateLiveData, stateObserver)

        viewModel.loadData()
    }

    companion object {

        const val ARG_COLUMN_COUNT = "column-count"

        @JvmStatic
        fun newInstance(columnCount: Int) =
            ItemListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}