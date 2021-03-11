package com.thk.feature_product.presentation.detail

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import coil.load
import coil.transform.RoundedCornersTransformation
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.thk.feature_product.R
import com.thk.feature_product.databinding.FragmentProductDetailBinding
import com.thk.menu.base.delegate.viewBinding
import com.thk.menu.base.presentation.extension.loadFromUrl
import com.thk.menu.base.presentation.fragment.InjectionFragment
import org.kodein.di.generic.instance

class ProductDetailFragment : InjectionFragment(R.layout.fragment_product_detail) {

    private val binding: FragmentProductDetailBinding by viewBinding()

    private val args: ProductDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val transformation: MaterialContainerTransform = MaterialContainerTransform().apply {
            fadeMode = MaterialContainerTransform.FADE_MODE_OUT
            duration = 500
        }
        sharedElementEnterTransition = transformation
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.root.transitionName = args.name
        binding.image.loadFromUrl(args.url)
        binding.name.text = args.name
        binding.salePrice.text = args.salePrice
    }
}