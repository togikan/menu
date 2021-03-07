package com.thk.feature_product

import com.thk.feature_product.data.dataModule
import com.thk.feature_product.domain.domainModule
import com.thk.feature_product.presentation.presentationModule
import com.thk.menu.core.feature.KodeinModuleProvider
import org.kodein.di.Kodein

internal const val MODULE_NAME = "Product"

object FeatureKodeinModule : KodeinModuleProvider {

    override val kodeinModule = Kodein.Module("${MODULE_NAME}Module") {
        import(presentationModule)
        import(domainModule)
        import(dataModule)
    }
}