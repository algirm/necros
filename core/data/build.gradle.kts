import id.northbit.gradle.iosCompat
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
    @Suppress("OPT_IN_USAGE") wasmJs { browser() }
    iosCompat()
}
setupAndroidLibrary()
android {
    namespace = "id.northbit.necros.core.data"
}
kotlin {
    applyDefaultHierarchyTemplate()
    sourceSets {
        val onlineBasedMain by creating { dependsOn(commonMain.get()) }
        val hybridMain by creating { dependsOn(commonMain.get()) }

        val androidMain by getting { dependsOn(hybridMain) }
        val jvmMain by getting { dependsOn(hybridMain) }
        val iosMain by getting { dependsOn(hybridMain) }
        val jsMain by getting { dependsOn(onlineBasedMain) }
        val wasmJsMain by getting { dependsOn(onlineBasedMain) }

        commonMain.dependencies { 
            // implementation of domain or other utils like serialization TODO
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.koin.core)
        }
        
        hybridMain.dependencies { 
            implementation(projects.core.database)
            implementation(libs.sqldelight.coroutines.extensions)
        }
    }
    
//    sourceSets {
//        commonMain.dependencies {
////            implementation(projects.core.database)
//        }
//        androidMain.dependencies {
//            api(projects.core.database)
//        }
//        jvmMain.dependencies {
//            implementation(libs.sqldelight.sqlite.driver)
//        }
//    }
}