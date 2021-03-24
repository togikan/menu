package com.thk.menu.base.extension

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.findNavController
import com.thk.menu.R

const val TAG_FRAGMENT_EXTENSION = "TAG_FRAGMENT_EXTENSION"

fun Fragment.navigateSafe(directions: NavDirections, navOptions: NavOptions? = null) {
    if (canNavigate()) findNavController().navigate(directions, navOptions)
}

fun Fragment.navigateSafe(directions: NavDirections, navigatorExtras: Navigator.Extras) {
    if (canNavigate()) findNavController().navigate(directions, navigatorExtras)
}

fun Fragment.canNavigate(): Boolean {
    val navController = findNavController()
    val destinationIdInNavController = navController.currentDestination?.id
    val destinationIdOfThisFragment = view?.getTag(R.id.tag_navigation_destination_id)
        ?: destinationIdInNavController
    return if (destinationIdInNavController == destinationIdOfThisFragment) {
        view?.setTag(R.id.tag_navigation_destination_id, destinationIdOfThisFragment)
        true
    } else {
        Log.d(
            "TAG_FRAGMENT_EXTENSION",
            "May not navigate: current destination is not the current fragment."
        )
        false
    }
}
