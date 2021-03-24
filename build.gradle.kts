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
        classpath (Config.Dependencies.gradle)
        classpath (Config.Dependencies.kotlin)
        classpath (Config.Dependencies.junit5)
        classpath (Config.Dependencies.safeArgs)
        classpath (Config.Dependencies.googleServices)
        classpath("org.jmailen.gradle:kotlinter-gradle:3.4.0")
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