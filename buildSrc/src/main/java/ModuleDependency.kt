import kotlin.reflect.full.memberProperties

object ModuleDependency {
    // All consts are accessed via reflection
    const val APP = ":app"
    const val FEATURE_ALBUM = ":feature_product"

    /*
    Return list of all modules in the project
     */
    private fun getAllModules() = ModuleDependency::class.memberProperties
        .filter { it.isConst }
        .map { it.getter.call().toString() }
        .toSet()

    /*
     Return list of feature modules in the project
     */
    fun getFeatureModules(): Set<String> {
        val featurePrefix = ":feature_"

        return getAllModules()
            .filter { it.startsWith(featurePrefix) }
            .toSet()
    }
}