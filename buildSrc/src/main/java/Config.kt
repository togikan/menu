object Config {
    const val compileSdk = 30
    const val minSdk = 23
    const val targetSdk = 30
    const val buildTools = "30.0.3"
    const val versionCode = 1
    const val versionName = "1.0.0"
    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"

    object ApplicationId {
        const val appId = "com.thk.menu"
        const val featureProduct = "com.thk.feature_product"
    }

    object Dependencies {
        const val gradle = "com.android.tools.build:gradle:${Version.GRADLE}"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.KOTLIN}"
        const val junit5 = "de.mannodermaus.gradle.plugins:android-junit5:${Version.JUNIT5}"
        const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.SAFE_ARGS}"
        const val googleServices = "com.google.gms:google-services:${Version.GOOGLE_SERVICES}"
    }

    object Plugins {
        const val app = "com.android.application"
        const val lib = "com.android.library"
        const val kotlinAndroid = "kotlin-android"
        const val junit5 = "de.mannodermaus.android-junit5"
        const val dynamicFeature = "com.android.dynamic-feature"
        const val kotlinKapt = "kotlin-kapt"
        const val safeArgs = "androidx.navigation.safeargs.kotlin"
        const val googleServices = "com.google.gms.google-services"
        const val kotlinter = "org.jmailen.kotlinter"
    }
}

interface BuildType {

    companion object {
        const val RELEASE = "release"
        const val DEBUG = "debug"
    }

    val isMinifyEnabled: Boolean
}

object BuildTypeDebug : BuildType {
    override val isMinifyEnabled = false
}

object BuildTypeRelease : BuildType {
    override val isMinifyEnabled = false
}

object TestOptions {
    const val IS_RETURN_DEFAULT_VALUES = true
}