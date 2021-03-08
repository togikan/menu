package com.thk.feature_product.presentation.detail

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.thk.feature_product.R
import com.thk.feature_product.databinding.FragmentProductDetailBinding
import com.thk.menu.base.delegate.viewBinding
import com.thk.menu.base.presentation.extension.observe
import com.thk.menu.base.presentation.fragment.InjectionFragment
import org.kodein.di.generic.instance

class ProductDetailFragment : InjectionFragment(R.layout.fragment_product_detail) {

    private val binding: FragmentProductDetailBinding by viewBinding()

    private val viewModel: ProductDetailViewModel by instance()

    private val stateObserver = Observer<ProductDetailViewModel.ViewState> {
//        binding.progressBar.visible = it.isLoading
//
//        binding.nameTextView.text = it.albumName
//        binding.nameTextView.visible = it.albumName.isNotBlank()
//
//        binding.artistTextView.text = it.artistName
//        binding.artistTextView.visible = it.artistName.isNotBlank()
//
//        binding.errorAnimation.visible = it.isError
//
//        val imageSize = 800
//
//        binding.coverImageView.load(it.coverImageUrl) {
//            size(imageSize, imageSize)
//        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe(viewModel.stateLiveData, stateObserver)

        viewModel.loadData()
    }
}