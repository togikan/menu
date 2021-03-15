import Library.addJupiterDependencies
import Library.addKluentDependencies
import Library.addRoomDependencies

plugins {
    id(Config.Plugins.dynamicFeature)
    id(Config.Plugins.kotlinAndroid)
    id(Config.Plugins.kotlinKapt)
    id(Config.Plugins.junit5)
    id(Config.Plugins.safeArgs)
}

android {
    compileSdkVersion(Config.compileSdk)

    defaultConfig {
        minSdkVersion(Config.minSdk)
        targetSdkVersion(Config.targetSdk)
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.testRunner
    }

    buildFeatures.viewBinding = true

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }

        getByName("debug") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    packagingOptions {
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
    }

    dependencies {
        implementation(project(ModuleDependency.APP))
        addRoomDependencies()
        addJupiterDependencies()
        addKluentDependencies()

        implementation(Library.RECYCLERVIEW)
        implementation(Library.LOTTIE)
        implementation(Library.COROUTINE_TEST)

        testImplementation(Library.ROOM_TESTING)
        testImplementation(Library.MOCKK)
        testImplementation(Library.KOTLIN_TEST_JUNIT)

        androidTestImplementation(Library.JUNIT)
        androidTestImplementation(Library.ESPRESSO)
        androidTestImplementation(Library.ANNOTATION)
        androidTestImplementation(Library.NAVIGATION_TESTING)
        androidTestImplementation(Library.FRAGMENT_TESTING)
    }
}