import org.gradle.api.artifacts.dsl.DependencyHandler

const val CONFIG_API = "api"
const val CONFIG_IMPLEMENTATION = "implementation"
const val CONFIG_TEST_IMPLEMENTATION = "testImplementation"
const val CONFIG_KAPT = "kapt"
const val CONFIG_TEST_RUNTIME_ONLY = "testRuntimeOnly"

object Library {
    //Kotlin
    const val KOTLIN_STD = "org.jetbrains.kotlin:kotlin-stdlib:${Version.KOTLIN}"
    const val KOTLIN_TEST_JUNIT = "org.jetbrains.kotlin:kotlin-test-junit:${Version.KOTLIN}"
    const val KOTLIN_REFLECT = "org.jetbrains.kotlin:kotlin-reflect:${Version.KOTLIN}"

    //Lifecycle
    const val VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.LIFECYCLE}"
    const val LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.LIFECYCLE}"
    const val LIFECYCLE_RUNTIME_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.LIFECYCLE}"
    const val VIEWMODEL_SAVED_STATE = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Version.LIFECYCLE}"
    const val LIFECYCLE_COMMON = "androidx.lifecycle:lifecycle-common-java8:${Version.LIFECYCLE}"

    //Kodein
    const val KODEIN_GENERIC = "org.kodein.di:kodein-di-generic-jvm:${Version.KODEIN}"
    const val KODEIN_FRAMEWORK = "org.kodein.di:kodein-di-framework-android-x:${Version.KODEIN}"

    //Retrofit
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Version.RETROFIT}"
    const val MOSHI = "com.squareup.retrofit2:converter-moshi:${Version.RETROFIT}"

    //Okhttp
    const val OKHTTP = "com.squareup.okhttp3:okhttp:${Version.OKHTTP}"
    const val OKHTTP_LOG = "com.squareup.okhttp3:logging-interceptor:${Version.OKHTTP}"

    //Navigation
    const val NAVIGATIION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:${Version.NAVIGATION}"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${Version.NAVIGATION}"
    const val NAVIGATION_DYNAMIC_FEATURES = "androidx.navigation:navigation-dynamic-features-fragment:${Version.NAVIGATION}"
    const val NAVIGATION_TESTING = "androidx.navigation:navigation-testing:${Version.NAVIGATION}"

    //Room
    const val ROOM_RUNTIME = "androidx.room:room-runtime:${Version.ROOM}"
    const val ROOM_COMPILER = "androidx.room:room-compiler:${Version.ROOM}"
    const val ROOM_KTX = "androidx.room:room-ktx:${Version.ROOM}"
    const val ROOM_TESTING = "androidx.room:room-testing:${Version.ROOM}"

    //Jupiter
    const val JUPITER_API = "org.junit.jupiter:junit-jupiter-api:${Version.JUPITER}"
    const val JUPITER_ENGINE = "org.junit.jupiter:junit-jupiter-engine:${Version.JUPITER}"
    const val JUPITER_PARAMS = "org.junit.jupiter:junit-jupiter-params:${Version.JUPITER}"

    //Kluent
    const val KLUENT = "org.amshove.kluent:kluent:${Version.KLUENT}"
    const val KLUENT_ANDROID = "org.amshove.kluent:kluent-android:${Version.KLUENT}"

    const val KTX = "androidx.core:core-ktx:${Version.KTX}"
    const val APP_COMPAT = "androidx.appcompat:appcompat:${Version.APP_COMPAT}"
    const val MATERIAL = "com.google.android.material:material:${Version.MATERIAL}"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Version.CONSTRAINT_LAYOUT}"
    const val PLAY_CORE = "com.google.android.play:core:${Version.PLAY_CORE}"
    const val ANNOTATION = "androidx.annotation:annotation:${Version.ANNOTATION}"
    const val FRAGMENT_TESTING = "androidx.fragment:fragment-testing:${Version.FRAGMENT_TESTING}"
    const val COIL = "io.coil-kt:coil:${Version.COIL}"
    const val JUNIT = "androidx.test.ext:junit:${Version.JUNIT}"
    const val ESPRESSO = "androidx.test.espresso:espresso-core:${Version.ESPRESSO}"
    const val RECYCLERVIEW = "androidx.recyclerview:recyclerview:${Version.RECYCLERVIEW}"
    const val LOTTIE = "com.airbnb.android:lottie:${Version.LOTTIE}"
    const val COROUTINE_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.COROUTINE_TEST}"
    const val MOCKK = "io.mockk:mockk:${Version.MOCKK}"
    const val ARCH = "androidx.arch.core:core-testing:${Version.ARCH}"

    fun DependencyHandler.addKotlinDependencies() {
        add(CONFIG_API, KOTLIN_STD)
        add(CONFIG_API, KOTLIN_REFLECT)
        add(CONFIG_TEST_IMPLEMENTATION, KOTLIN_STD)
    }

    fun DependencyHandler.addLifecycleDependencies() {
        add(CONFIG_IMPLEMENTATION, VIEWMODEL)
        add(CONFIG_IMPLEMENTATION, LIVEDATA)
        add(CONFIG_IMPLEMENTATION, LIFECYCLE_RUNTIME_KTX)
        add(CONFIG_IMPLEMENTATION, VIEWMODEL_SAVED_STATE)
        add(CONFIG_IMPLEMENTATION, LIFECYCLE_COMMON)
    }

    fun DependencyHandler.addKodeinDependencies() {
        add(CONFIG_API, KODEIN_GENERIC)
        add(CONFIG_API, KODEIN_FRAMEWORK)
    }

    fun DependencyHandler.addRetrofitDependencies() {
        add(CONFIG_IMPLEMENTATION, RETROFIT)
        add(CONFIG_API, MOSHI)
    }

    fun DependencyHandler.addOkhttpDependencies() {
        add(CONFIG_IMPLEMENTATION, OKHTTP)
        add(CONFIG_IMPLEMENTATION, OKHTTP_LOG)
    }

    fun DependencyHandler.addNavigationDependencies() {
        add(CONFIG_API, NAVIGATIION_FRAGMENT)
        add(CONFIG_API, NAVIGATION_UI)
        add(CONFIG_IMPLEMENTATION, NAVIGATION_DYNAMIC_FEATURES)
    }

    fun DependencyHandler.addRoomDependencies() {
        add(CONFIG_KAPT, ROOM_COMPILER)
        add(CONFIG_IMPLEMENTATION, ROOM_RUNTIME)
        add(CONFIG_IMPLEMENTATION, ROOM_KTX)
    }

    fun DependencyHandler.addJupiterDependencies() {
        add(CONFIG_TEST_IMPLEMENTATION, JUPITER_API)
        add(CONFIG_TEST_IMPLEMENTATION, JUPITER_PARAMS)
        add(CONFIG_TEST_RUNTIME_ONLY, JUPITER_ENGINE)
    }

    fun DependencyHandler.addJupiterTestDependencies() {
        add(CONFIG_IMPLEMENTATION, JUPITER_API)
        add(CONFIG_IMPLEMENTATION, JUPITER_PARAMS)
        add(CONFIG_TEST_RUNTIME_ONLY, JUPITER_ENGINE)
    }

    fun DependencyHandler.addKluentDependencies() {
        add(CONFIG_TEST_IMPLEMENTATION, KLUENT)
        add(CONFIG_TEST_IMPLEMENTATION, KLUENT_ANDROID)
    }
}

object Version {
    const val KOTLIN = "1.4.31"
    const val GRADLE = "4.0.1"
    const val JUNIT5 = "1.7.1.1"
    const val SAFE_ARGS = "2.3.3"
    const val KTX = "1.3.2"
    const val APP_COMPAT = "1.2.0"
    const val MATERIAL = "1.3.0"
    const val CONSTRAINT_LAYOUT = "2.0.4"
    const val PLAY_CORE = "1.10.0"
    const val LIFECYCLE = "2.3.0"
    const val KODEIN = "6.5.5"
    const val RETROFIT = "2.9.0"
    const val OKHTTP = "4.9.1"
    const val NAVIGATION = "2.3.3"
    const val COIL = "1.1.1"
    const val JUNIT = "1.1.2"
    const val ESPRESSO = "3.3.0"
    const val RECYCLERVIEW = "1.1.0"
    const val LOTTIE = "3.6.1"
    const val COROUTINE_TEST = "1.4.3"
    const val ROOM = "2.2.6"
    const val MOCKK = "1.11.0"
    const val JUPITER = "5.7.1"
    const val KLUENT = "1.65"
    const val ANNOTATION = "1.1.0"
    const val FRAGMENT_TESTING = "1.3.0"
    const val ARCH = "2.1.0"
}