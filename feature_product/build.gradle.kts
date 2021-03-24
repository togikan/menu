import Library.addEspressoDependencies
import Library.addJupiterDependencies
import Library.addKluentDependencies
import Library.addRoomDependencies

plugins {
    id(Config.Plugins.DYNAMIC_FEATURE)
    id(Config.Plugins.KOTLIN_ANDROID)
    id(Config.Plugins.KOTLIN_KAPT)
    id(Config.Plugins.JUNIT5)
    id(Config.Plugins.SAFE_ARGS)
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

    buildFeatures.viewBinding = true

    buildTypes {
        getByName(BuildType.RELEASE) {
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            proguardFiles("proguard-android.txt", "proguard-rules.pro")
        }

        getByName(BuildType.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
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

    testOptions {
        unitTests.isReturnDefaultValues = TestOptions.IS_RETURN_DEFAULT_VALUES
    }
}

dependencies {
    implementation(project(ModuleDependency.APP))
    implementation(Library.RECYCLERVIEW)
    implementation(Library.LOTTIE)
    addRoomDependencies()

    testImplementation(project(ModuleDependency.LIBRARY_TEST_EXTENSION))
    testImplementation(Library.ROOM_TESTING)
    testImplementation(Library.MOCKK)
    testImplementation(Library.KOTLIN_TEST_JUNIT)
    testImplementation(Library.COROUTINE_TEST)
    addJupiterDependencies()
    addKluentDependencies()

    androidTestImplementation(Library.JUNIT)
    androidTestImplementation(Library.ANNOTATION)
    androidTestImplementation(Library.NAVIGATION_TESTING)
    androidTestImplementation(Library.TEST_RULES)
    addEspressoDependencies()
}