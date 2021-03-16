package com.thk.feature_product.presentation.detail

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.transition.MaterialContainerTransform
import com.thk.feature_product.R
import com.thk.feature_product.databinding.FragmentProductDetailBinding
import com.thk.menu.base.delegate.viewBinding
import com.thk.menu.base.presentation.extension.loadFromUrl
import com.thk.menu.base.presentation.fragment.InjectionFragment

class ProductDetailFragment : InjectionFragment(R.layout.fragment_product_detail) {

    private val binding: FragmentProductDetailBinding by viewBinding()

    private val args: ProductDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val transformation: MaterialContainerTransform = MaterialContainerTransform().apply {
            fadeMode = MaterialContainerTransform.FADE_MODE_OUT
            duration = resources.getInteger(R.integer.duration_animation_fade).toLong()
            scrimColor = Color.TRANSPARENT
        }
        sharedElementEnterTransition = transformation
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.setActionBar(binding.toolbar)
        activity?.actionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        binding.root.transitionName = args.name
        binding.image.loadFromUrl(args.url)
        binding.collapsingToolbarLayout.title = args.name
        binding.salePrice.text = args.salePrice
    }
}