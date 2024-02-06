rootProject.name = "Necros"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://jitpack.io")
    }

    resolutionStrategy {
        eachPlugin {
            if (requested.id.toString() == "id.northbit.gradle.util") {
                useModule("com.github.algirm:gradle-util-plugin:de150700bf")
            }
        }
    }

    plugins {
        id("id.northbit.gradle.util")
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

include(":shared")
include(":core:ui:compose")
include(":app-android:androidApp")
include(":app-web:jsApp")
include(":app-web:wasmJsApp")