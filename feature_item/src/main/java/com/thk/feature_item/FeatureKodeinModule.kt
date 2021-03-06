package com.thk.feature_item

import com.thk.feature_item.presentation.presentationModule
import com.thk.menu.core.feature.KodeinModuleProvider
import org.kodein.di.Kodein

internal const val MODULE_NAME = "Item"

object FeatureKodeinModule : KodeinModuleProvider {

    override val kodeinModule = Kodein.Module("${MODULE_NAME}Module") {
        import(presentationModule)
    }
}