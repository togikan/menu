import Library.addKodeinDependencies
import Library.addKotlinDependencies
import Library.addLifecycleDependencies
import Library.addNavigationDependencies
import Library.addOkhttpDependencies
import Library.addRetrofitDependencies
import com.android.build.gradle.internal.dsl.DefaultConfig

plugins {
    id(Config.Plugins.APP)
    id(Config.Plugins.KOTLIN_ANDROID)
    id(Config.Plugins.JUNIT5)
    id(Config.Plugins.GOOGLE_SERVICES)
    id(Config.Plugins.KOTLINTER)
}

android {
    compileSdkVersion(Config.COMPILE_SDK)
    buildToolsVersion(Config.BUILD_TOOLS)

    defaultConfig {
        applicationId = Config.ApplicationId.APP_ID
        minSdkVersion(Config.MIN_SDK)
        targetSdkVersion(Config.TARGET_SDK)
        versionCode = Config.VERSION_CODE
        versionName = Config.VERSION_NAME

        testInstrumentationRunner = Config.TEST_RUNNER

        buildConfigField(
            "String",
            "API_BASE_URL",
            "\"http://mobcategories.s3-website-eu-west-1.amazonaws.com\""
        )

        buildConfigField("FEATURE_MODULE_NAMES", getFeatureNames())
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

    dynamicFeatures = ModuleDependency.getFeatureModules().toMutableSet()
}

dependencies {
    addKotlinDependencies()
    addLifecycleDependencies()
    addKodeinDependencies()
    addRetrofitDependencies()
    addOkhttpDependencies()
    addNavigationDependencies()

    api(Library.KTX)
    api(Library.COIL)

    implementation(platform(Library.FIREBASE_BOM))
    implementation(Library.APP_COMPAT)
    implementation(Library.MATERIAL)
    implementation(Library.CONSTRAINT_LAYOUT)
    implementation(Library.PLAY_CORE)

    androidTestImplementation(Library.JUNIT)
    androidTestImplementation(Library.ESPRESSO)
}

/*
Return names of the features
 */
fun getFeatureNames() = ModuleDependency.getFeatureModules()
    .map { it.replace(":feature_", "") }
    .toSet()

fun String.toSnakeCase() = this.split(Regex("(?=[A-Z])")).joinToString("_") { it.toLowerCase() }

/*
Adds a new field to the generated BuildConfig class
 */
fun DefaultConfig.buildConfigField(name: String, value: Set<String>) {
    // Create String that holds Java String Array code
    val strValue =
        value.joinToString(prefix = "{", separator = ",", postfix = "}", transform = { "\"$it\"" })
    buildConfigField("String[]", name, strValue)
}
