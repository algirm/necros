import id.northbit.gradle.bundle
import id.northbit.gradle.dependsOn
import id.northbit.gradle.iosCompat
import id.northbit.gradle.setupAndroidLibrary
import id.northbit.gradle.setupMultiplatform
import id.northbit.gradle.setupSourceSets

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.gradleUtil)
    alias(libs.plugins.sqlDelight)
}

setupMultiplatform {
    androidTarget()
    jvm()
//    @Suppress("OPT_IN_USAGE") wasmJs()
    iosCompat()
}

setupAndroidLibrary()

android {
    namespace = "id.northbit.necros.core.database"
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared)

            implementation(libs.sqldelight.runtime)
        }
        androidMain.dependencies {
            implementation(libs.sqldelight.android.driver)
        }
        iosMain.dependencies {
            implementation(libs.sqldelight.native.driver)
        }
        jvmMain.dependencies {
            implementation(libs.sqldelight.sqlite.driver)
        }
    }
}

sqldelight {
    databases {
        create("AppDatabase") {
            packageName.set("id.northbit.necros.core.database")
        }
    }
}



