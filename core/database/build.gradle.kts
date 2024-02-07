import id.northbit.gradle.iosCompat
import id.northbit.gradle.setupAndroidLibrary
import id.northbit.gradle.setupMultiplatform

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.gradleUtil)
    alias(libs.plugins.sqlDelight)
}

setupMultiplatform {
    androidTarget()
    jvm()
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



