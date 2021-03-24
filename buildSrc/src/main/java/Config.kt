object Config {
    const val COMPILE_SDK = 30
    const val MIN_SDK = 23
    const val TARGET_SDK = 30
    const val BUILD_TOOLS = "30.0.3"
    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0.0"
    const val TEST_RUNNER = "androidx.test.runner.AndroidJUnitRunner"

    object ApplicationId {
        const val APP_ID = "com.thk.menu"
    }

    object Dependencies {
        const val GRADLE = "com.android.tools.build:gradle:${Version.GRADLE}"
        const val KOTLIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.KOTLIN}"
        const val JUNIT5 = "de.mannodermaus.gradle.plugins:android-junit5:${Version.JUNIT5}"
        const val SAFE_ARGS = "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.SAFE_ARGS}"
        const val GOOGLE_SERVICES = "com.google.gms:google-services:${Version.GOOGLE_SERVICES}"
        const val KOTLINTER = "org.jmailen.gradle:kotlinter-gradle:${Version.KOTLINTER}"
    }

    object Plugins {
        const val APP = "com.android.application"
        const val LIB = "com.android.library"
        const val KOTLIN_ANDROID = "kotlin-android"
        const val JUNIT5 = "de.mannodermaus.android-junit5"
        const val DYNAMIC_FEATURE = "com.android.dynamic-feature"
        const val KOTLIN_KAPT = "kotlin-kapt"
        const val SAFE_ARGS = "androidx.navigation.safeargs.kotlin"
        const val GOOGLE_SERVICES = "com.google.gms.google-services"
        const val KOTLINTER = "org.jmailen.kotlinter"
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