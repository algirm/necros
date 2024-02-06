import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
}

group = "com.example"
version = "1.0-SNAPSHOT"

kotlin {
    @OptIn(org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl::class)
    wasmJs {
        moduleName = "wasmJsApp"
//        browser()
        browser {
            commonWebpackConfig {
                outputFileName = "wasmJsApp.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    // Uncomment and configure this if you want to open a browser different from the system default 
                    // open = mapOf(
                    //     "app" to mapOf(
                    //         "name" to "google chrome"
                    //     )
                    // )

                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(project.rootDir.path)
                        add(project.rootDir.path + "/shared/common/commonMain/")
                        add(project.rootDir.path + "/shared/common/build/processedResources/wasmJs/main/")
//                        add(project.rootDir.path + "/nonAndroidMain/")
//                        add(project.rootDir.path + "/web/")
                    }
                }
            }
        }
        binaries.executable()
        //applyBinaryen()
    }
    sourceSets {
//        commonMain.dependencies {
////            dependencies {
//            implementation(compose.runtime)
//            implementation(compose.foundation)
//            implementation(compose.material3)
////                implementation(compose.ui)
//
//            @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
//            implementation(compose.components.resources)
////                implementation(projects.shared.common)
//            implementation(project(":shared:common"))
//            implementation(project(":shared:compose"))
////            }
//        }
        val wasmJsMain by getting {
            dependencies {
                implementation(projects.shared)
                implementation(projects.sharedCompose)
                
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
//                implementation(compose.ui)
                
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
            }
        }
    }
}

dependencies {
//    commonMainImplementation(projects.shared.common)
//    commonMainImplementation(projects.shared.compose)
//    commonMainImplementation(project(":shared:common"))
//    commonMainImplementation(project(":shared:compose"))
//    implementation()
}


compose.experimental {
    web.application {}
}
