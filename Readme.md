# Menu

List/Detail menu application assignment

App tested with Android versions 6, 9 and 11
## Features

- List menu items
- Show menu item details
- Supports offline usage
- Supports dark theme (night mode in Samsung devices)

## Characteristics

[Modular Architecture](https://www.youtube.com/watch?v=PZBg5DIzNww)
- More scalable and maintainable
- Faster incremental compilation
- Make use of [app bundles](https://developer.android.com/guide/app-bundle) and [dynamic delivery](https://developer.android.com/guide/app-bundle/play-feature-delivery). It will let on demand delivery and have smaller install sizes.
- Isolated feature testing

Clean Architecture (feature module level)

[Single Activity architecture](https://www.youtube.com/watch?v=2k8x8V77CrU)

[MVVM](https://developer.android.com/jetpack/guide) + [MVI](https://www.raywenderlich.com/817602-mvi-architecture-for-android-tutorial-getting-started)

## Tech stack

[Navigation component](https://developer.android.com/guide/navigation) + [SafeArgs](https://developer.android.com/guide/navigation/navigation-pass-data)

[ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)

[LiveData](https://developer.android.com/topic/libraries/architecture/livedata)

[Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle)

[Room](https://developer.android.com/jetpack/androidx/releases/room)

[Material Motion](https://material.io/develop/android/theming/motion)

[Kodein](https://kodein.org/Kodein-DI/?5.0/android) kotlin friendly DI

[Retrofit](https://square.github.io/retrofit/)

[Coil](https://github.com/coil-kt/coil) kotlin friendly image loader

[Junit5](https://github.com/mannodermaus/android-junit5)

[Mockk](https://mockk.io/)

[Kluent](https://github.com/MarkusAmshove/Kluent)

## UI
[Used color palette depending on this article.](https://awgsalesservices.com/2016/04/21/color-psychology-in-food-marketing/#:~:text=Yellow%20and%20orange%20are%20colors,orange%2C%20they%20become%20passionately%20hungry.)

[Used material color tool](https://material.io/resources/color/)

## TODOs
Use kotlin DSL for improved dependency management and get module names dynamically

Improve fade animation


## Inspired from projects

https://github.com/android

https://github.com/google-developer-training/android-kotlin-fundamentals-apps

https://github.com/android/sunflower

https://github.com/igorwojda/android-showcase

https://github.com/android/architecture-samples

https://github.com/material-components/material-components-android

https://github.com/bufferapp/android-clean-architecture-boilerplate