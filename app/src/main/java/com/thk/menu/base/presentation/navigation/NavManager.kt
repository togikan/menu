package com.thk.menu.base.presentation.navigation

import androidx.navigation.NavDirections
import androidx.navigation.Navigator

class NavManager {
    private var navEventListener: ((
        navDirections: NavDirections,
        navigatorExtras: Navigator.Extras
    ) -> Unit)? = null

    fun navigate(
        navDirections: NavDirections,
        navigatorExtras: Navigator.Extras
    ) {
        navEventListener?.invoke(navDirections, navigatorExtras)
    }

    fun setOnNavEvent(
        navEventListener: (
            navDirections: NavDirections,
            navigatorExtras: Navigator.Extras
        ) -> Unit
    ) {
        this.navEventListener = navEventListener
    }
}