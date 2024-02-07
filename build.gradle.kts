import id.northbit.gradle.AndroidConfig
import id.northbit.gradle.setupDefaults

plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.jetbrainsCompose) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.gradleUtil) apply false
    alias(libs.plugins.sqlDelight) apply false

    // To format alphabetically and auto update version of libs version.
    id("com.github.ben-manes.versions") version "0.41.0"
    id("nl.littlerobots.version-catalog-update") version "0.8.3"
    // ./gradlew versionCatalogUpdate → Automatically updates dependency versions, formats them, and sorts them alphabetically.
    // ./gradlew versionCatalogUpdate --interactive → Lists updatable dependencies but does not automatically update them.
    // ./gradlew versionCatalogApplyUpdates → Approves the updates listed for dependencies.
    // ./gradlew versionCatalogFormat → Formats and alphabetically sorts the version catalog.
    // **Close with comment block after using the plugin**
}

setupDefaults(
    androidConfig = AndroidConfig(
        compileSdkVersion = libs.versions.androidCompileSdk.get().toInt(),
        minSdkVersion = libs.versions.androidMinSdk.get().toInt(),
        targetSdkVersion = libs.versions.androidTargetSdk.get().toInt()
    )
)

versionCatalogUpdate {
    versionCatalogs {
        keep {
            keepUnusedVersions = true
            keepUnusedLibraries = true
            keepUnusedPlugins = true
        }
    }
}
