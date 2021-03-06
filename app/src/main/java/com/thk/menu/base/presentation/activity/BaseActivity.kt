package com.thk.menu.base.presentation.activity

import android.os.Bundle
import android.view.WindowManager

abstract class BaseActivity : InjectionActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        // The window will not be resized when virtual keyboard is shown
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)
    }
}