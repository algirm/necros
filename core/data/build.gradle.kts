import id.northbit.gradle.setupAndroidLibrary
import id.northbit.gradle.setupMultiplatform

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.gradleUtil)
//    alias(libs.plugins.sqlDelight)
}
setupMultiplatform {
    androidTarget()
    jvm()
    js { browser() }
    @Suppress("OPT_IN_USAGE") wasmJs()
}
setupAndroidLibrary()
android {
    namespace = "id.northbit.necros.core.data"
}
kotlin {

    sourceSets {
        commonMain.dependencies {
//            implementation(projects.core.database)
        }
        androidMain.dependencies {
            api(projects.core.database)
        }
        jvmMain.dependencies {
            implementation(libs.sqldelight.sqlite.driver)
        }
    }
}