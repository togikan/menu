package com.thk.menu.core.feature

object FeatureManager {

    //TODO: Use kotlin DSL for gradle to get module names dynamically
    val kodeinModules = arrayOf("module")
        .map { "com.thk.feature_product.FeatureKodeinModule" }
        .map {
            try {
                Class.forName(it).kotlin.objectInstance as KodeinModuleProvider
            } catch (e: ClassNotFoundException) {
                throw ClassNotFoundException("Kodein module class not found $it")
            }
        }
        .map { it.kodeinModule }
}