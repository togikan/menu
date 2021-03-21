package com.thk.menu.core.presentation

import android.os.Bundle
import androidx.navigation.NavDirections
import androidx.navigation.Navigator
import com.thk.menu.R
import com.thk.menu.base.delegate.viewBinding
import com.thk.menu.base.extension.navigateSafe
import com.thk.menu.base.presentation.activity.BaseActivity
import com.thk.menu.base.presentation.navigation.NavManager
import com.thk.menu.databinding.ActivityNavHostBinding
import org.kodein.di.generic.instance

class NavHostActivity : BaseActivity() {

    private val binding: ActivityNavHostBinding by viewBinding()

    private val navManager: NavManager by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initNavManager()
    }

    private fun initNavManager() {
        navManager.setOnNavEvent { navDirections: NavDirections, extras: Navigator.Extras ->
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment)
            val currentFragment = navHostFragment?.childFragmentManager?.fragments?.get(0)

            currentFragment?.navigateSafe(navDirections, extras)
        }
    }
}