//@file:Suppress("OPT_IN_USAGE")

import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsCompose)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    jvm()
//    js { browser() }
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
////        binaries.executable()
    }

    sourceSets {

        androidMain.dependencies {
            implementation(projects.core.database)

            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.koin.core)
            
//            implementation(compose.uiTooling)
//            implementation(compose.preview)
        }
        commonMain.dependencies {
            implementation(projects.core.data)
            implementation(projects.shared)

            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)

            implementation(libs.kotlinx.datetime)

//            implementation(compose.uiTooling)
//            implementation(compose.preview)

//            implementation(libs.koin.core)
        }
    }
}

dependencies {
//    implementation(projects.shared.common)

}

android {
    namespace = "id.northbit.necros.ui.compose"
    compileSdk = libs.versions.androidCompileSdk.get().toInt()

//    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
//    sourceSets["main"].res.srcDirs("src/androidMain/res")
//    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        minSdk = libs.versions.androidMinSdk.get().toInt()
//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
//    packaging {
//        resources {
//            excludes += "/META-INF/{AL2.0,LGPL2.1}"
//        }
//    }
//    buildTypes {
//        getByName("release") {
//            isMinifyEnabled = false
//        }
//    }
//    buildFeatures { 
//        compose = true
//    }
//    composeOptions {
//        kotlinCompilerExtensionVersion = "1.5.5"
//    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    dependencies {
//        debugImplementation(libs.compose.ui.tooling)
        debugImplementation(compose.uiTooling)
    }
}


//compose.experimental {
//    web.application {}
//}

//kotlin.sourceSets.all {
//    languageSettings.optIn("kotlin.experimental.ExperimentalObjCName")
//}