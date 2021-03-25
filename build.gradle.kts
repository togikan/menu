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

plugins {
    id("io.gitlab.arturbosch.detekt") version("1.16.0")
    id("com.diffplug.spotless") version "5.7.0"
}

detekt {
    toolVersion = "1.16.0"
    allRules = true
    config = files("config/detekt/detekt.yml")
    buildUponDefaultConfig = true

    reports {
        xml {
            enabled = false
        }
        html {
            enabled = true
            destination = file("build/reports/detekt.html")
        }
        txt {
            enabled = false
        }
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

subprojects {

    project.pluginManager.apply("com.diffplug.spotless")

    spotless {
        java {
            target("**/*.java")
            targetExclude("**/build/**/*.java")
            removeUnusedImports()
            trimTrailingWhitespace()
            indentWithSpaces()
            googleJavaFormat()
        }

        kotlin {
            target("**/*.kt")
            targetExclude("**/build/**/*.kt")
            ktlint("0.40.0")
            trimTrailingWhitespace()
            indentWithSpaces()
            endWithNewline()
        }

        kotlinGradle {
            target("**/*.gradle.kts")
            ktlint("0.40.0")
        }

        format("misc") {
            target("**/.gitignore", "**/*.gradle", "**/*.md", "**/*.sh", "**/*.yml")
            trimTrailingWhitespace()
            endWithNewline()
        }
    }
}