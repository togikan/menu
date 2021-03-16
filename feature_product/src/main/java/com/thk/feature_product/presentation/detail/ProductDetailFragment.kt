package com.thk.feature_product.presentation.detail

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.core.view.ViewCompat
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.transition.MaterialContainerTransform
import com.thk.feature_product.R
import com.thk.feature_product.databinding.FragmentProductDetailBinding
import com.thk.menu.base.delegate.viewBinding
import com.thk.menu.base.presentation.extension.loadFromUrl
import com.thk.menu.base.presentation.fragment.InjectionFragment
import java.util.*
import kotlin.concurrent.schedule


class ProductDetailFragment : InjectionFragment(R.layout.fragment_product_detail) {

    private val binding: FragmentProductDetailBinding by viewBinding()

    private val args: ProductDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val animationDelay = resources.getInteger(R.integer.duration_animation_fade).toLong()

        ViewCompat.setTransitionName(binding.containerDetail, args.name)
        val transformation: MaterialContainerTransform = MaterialContainerTransform().apply {
            fadeMode = MaterialContainerTransform.FADE_MODE_OUT
            duration = animationDelay
            scrimColor = Color.TRANSPARENT
            drawingViewId = com.thk.menu.R.id.navHostFragment
        }
        sharedElementEnterTransition = transformation

        activity?.setActionBar(binding.toolbar)
        activity?.actionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        ViewCompat.setElevation(binding.toolbar, 0f)
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        binding.image.loadFromUrl(args.url)
        binding.collapsingToolbarLayout.title = args.name
        binding.salePrice.text = args.salePrice

        Timer("Snackbar", false).schedule(animationDelay) {
            Snackbar.make(
                binding.containerDetail,
                getString(R.string.collapsing),
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }
}