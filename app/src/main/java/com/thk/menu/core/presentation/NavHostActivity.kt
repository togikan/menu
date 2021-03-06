package com.thk.menu.core.presentation

import android.os.Bundle
import com.thk.menu.R
import com.thk.menu.base.presentation.activity.BaseActivity

class NavHostActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_host)
    }
}