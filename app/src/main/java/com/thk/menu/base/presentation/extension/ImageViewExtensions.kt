package com.thk.menu.base.presentation.extension

import android.widget.ImageView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.thk.menu.R

fun ImageView.loadFromUrl(url: String?, roundedCorners: Boolean = false) {
    load(url) {
        crossfade(true)
        error(R.drawable.ic_image)
        if (roundedCorners) {
            transformations(RoundedCornersTransformation(10F))
        }
    }
}