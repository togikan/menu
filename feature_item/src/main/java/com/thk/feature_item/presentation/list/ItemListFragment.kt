package com.thk.feature_item.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.thk.feature_item.R
import com.thk.feature_item.databinding.FragmentMenuItemListBinding
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
//        itemAdapter.albums = it.albums
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
        super.onViewCreated(view, savedInstanceState)

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