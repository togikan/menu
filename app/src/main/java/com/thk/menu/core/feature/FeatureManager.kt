package com.thk.menu.core.feature

import com.thk.menu.BuildConfig

object FeatureManager {

    private const val featurePackagePrefix = "com.thk.feature"

    val kodeinModules = BuildConfig.FEATURE_MODULE_NAMES
        .map { "${featurePackagePrefix}_$it.FeatureKodeinModule" }
        .map {
            try {
                Class.forName(it).kotlin.objectInstance as KodeinModuleProvider
            } catch (e: ClassNotFoundException) {
                throw ClassNotFoundException("Kodein module class not found $it")
            }
        }
        .map { it.kodeinModule }
}