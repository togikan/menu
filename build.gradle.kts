// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath (Config.Dependencies.GRADLE)
        classpath (Config.Dependencies.KOTLIN)
        classpath (Config.Dependencies.JUNIT5)
        classpath (Config.Dependencies.SAFE_ARGS)
        classpath (Config.Dependencies.GOOGLE_SERVICES)
        classpath (Config.Dependencies.KOTLINTER)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks {
  val clean by registering(Delete::class) {
      delete(buildDir)
  }
}