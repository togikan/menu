package com.thk.menu.core.presentation

import android.os.Bundle
import com.thk.menu.base.delegate.viewBinding
import com.thk.menu.base.presentation.activity.BaseActivity
import com.thk.menu.databinding.ActivityNavHostBinding

class NavHostActivity : BaseActivity() {

    private val binding: ActivityNavHostBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}