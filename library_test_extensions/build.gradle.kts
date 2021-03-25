import Library.addJupiterTestDependencies
import Library.addKotlinDependencies

plugins {
    id(Config.Plugins.LIB)
    id(Config.Plugins.KOTLIN_ANDROID)
    id(Config.Plugins.JUNIT5)
    id(Config.Plugins.KOTLINTER)
}

android {
    compileSdkVersion(Config.COMPILE_SDK)

    defaultConfig {
        minSdkVersion(Config.MIN_SDK)
        targetSdkVersion(Config.TARGET_SDK)
        versionCode = Config.VERSION_CODE
        versionName = Config.VERSION_NAME

        testInstrumentationRunner = Config.TEST_RUNNER
    }

    buildTypes {
        getByName(BuildType.RELEASE) {
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            proguardFiles("proguard-android.txt", "proguard-rules.pro")
        }

        getByName(BuildType.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
        }
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    testOptions {
        unitTests.isReturnDefaultValues = TestOptions.IS_RETURN_DEFAULT_VALUES
    }

    packagingOptions {
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
    }
}

dependencies {
    addKotlinDependencies()
    addJupiterTestDependencies()
    implementation(Library.COROUTINE_TEST)
    implementation(Library.ARCH)
}
