package com.thk.menu.base.di

import com.thk.menu.base.presentation.navigation.NavigationManager
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

internal const val MODULE_NAME = "Base"

val baseModule = Kodein.Module("${MODULE_NAME}Module") {

    bind() from singleton { NavigationManager() }
}