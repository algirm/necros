import org.jetbrains.kotlin.gradle.plugin.KotlinTarget
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

//@file:Suppress("OPT_IN_USAGE")

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
//    alias(libs.plugins.jetbrainsCompose)
}

kotlin {
//    jvmToolchain(17)

//    @OptIn(ExperimentalWasmDsl::class)
//    wasmJs {
//        moduleName = "shared"
//        browser {
//            commonWebpackConfig {
//                outputFileName = "composeApp.js"
//            }
//        }
//        binaries.executable()
//    }

//    js {
//        useCommonJs()
//        browser()
//    }
//    androidTarget()
//    jvm()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
//        iosTarget.compilations.configureEach { 
//            compileTaskProvider.get().enabled = false
//        }
        iosTarget.binaries.framework {
            baseName = "SharedCommon"
            isStatic = true
        }
    }
    androidTarget()
    jvm()
    js { 
//        useCommonJs()
        browser()
    }
    @OptIn(org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl::class) wasmJs {
//        moduleName = "wasmJsApp"\
        browser()
//        browser {
//            commonWebpackConfig {
//                outputFileName = "wasmJsApp.js"
//                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
//                    // Uncomment and configure this if you want to open a browser different from the system default 
//                    // open = mapOf(
//                    //     "app" to mapOf(
//                    //         "name" to "google chrome"
//                    //     )
//                    // )
//
//                    static = (static ?: mutableListOf()).apply {
//                        // Serve sources to debug inside browser
//                        add(project.rootDir.path)
//                        add(project.rootDir.path + "/shared/common/commonMainasd/")
////                        add(project.rootDir.path + "/nonAndroidMain/")
////                        add(project.rootDir.path + "/web/")
//                    }
//                }
//            }
//        }
//        binaries.executable()
    }
//
//    js(IR) {
//        useCommonJs()
//        browser()
//    }
    sourceSets {

//        androidMain.dependencies {
////            implementation(libs.compose.ui.tooling.preview)
////            implementation(libs.androidx.activity.compose)
////            implementation(libs.koin.core)
//        }
        commonMain.dependencies {
//            implementation(compose.runtime)
//            implementation(compose.foundation)
//            implementation(compose.material)
//            implementation(compose.ui)
//            @OptIn(ExperimentalComposeLibrary::class)
//            implementation(compose.components.resources)

            implementation(libs.kotlinx.datetime)
            implementation(libs.decompose)
//            implementation(libs.kotlinx.coroutines.core)
//            implementation(libs.koin.core)

//            implementation("com.squareup.sqldelight:runtime:1.5.5")
//            implementation("com.slack.circuit:circuit-foundation:0.18.2")
        }
//        val jsWasmMain by getting {
//            dependsOn(commonMain.get())
//        }
//        val jsMain by getting {
//            dependsOn(jsWasmMain)
//        }
//        val wasmJsMain by getting {
//            dependsOn(commonMain.get())
//        }
    }
}

android {
    namespace = "id.northbit.necros.shared"
    compileSdk = libs.versions.androidCompileSdk.get().toInt()

//    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
//    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")
    
    defaultConfig {
        minSdk = libs.versions.androidMinSdk.get().toInt()
//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
//    buildTypes {
//        getByName("release") {
//            isMinifyEnabled = false
//        }
//    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    dependencies {
        debugImplementation(libs.compose.ui.tooling)
    }
}


//compose.experimental {
//    web.application {}
//}

//kotlin.sourceSets.all {
//    languageSettings.optIn("kotlin.experimental.ExperimentalObjCName")
//}