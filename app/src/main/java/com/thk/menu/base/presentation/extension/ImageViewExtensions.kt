package com.thk.menu.base.presentation.extension

import android.widget.ImageView
import coil.load
import com.thk.menu.R

fun ImageView.loadFromUrl(url: String?) {
    load(url) {
        crossfade(true)
        error(R.drawable.ic_image)
    }
}