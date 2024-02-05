import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.kotlinMultiplatform)
}

//group = "com.example"
//version = "1.0-SNAPSHOT"

kotlin {
    js {
        moduleName = "necrosJsApp"
        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled.set(true)
                }
                outputFileName = "necrosJsApp.js"
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
//                        add(project.rootDir.path + "/shared/common/commonMain/")
//                        add(project.rootDir.path + "/shared/common/build/processedResources/wasmJs/main/")
//                        add(project.rootDir.path + "/nonAndroidMain/")
//                        add(project.rootDir.path + "/web/")
                    }
                }
            }
        }
        binaries.executable()
    }
    sourceSets {
//        val commonMain by getting {
//            dependencies {
//                implementation(project.dependencies.enforcedPlatform(libs.jetbrains.kotlinWrappers.kotlinWrappersBom.get()))
//                implementation("org.jetbrains.kotlin-wrappers:kotlin-react")
//                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom")
//                implementation("org.jetbrains.kotlin-wrappers:kotlin-styled")
//                implementation("org.jetbrains.kotlin-wrappers:kotlin-css-js")
//                implementation("org.jetbrains.kotlin-wrappers:kotlin-mui")
//            }
//        }
        val jsMain by getting {
            dependencies {
                implementation(project(":shared:common"))

                implementation(project.dependencies.enforcedPlatform(libs.jetbrains.kotlinWrappers.kotlinWrappersBom.get()))
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-styled")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-css-js")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-mui")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-emotion")
            }
        }
    }
}

//dependencies {
//    implementation("org.jetbrains.kotlin-wrappers:kotlin-react")
//    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom")
//    implementation("org.jetbrains.kotlin-wrappers:kotlin-styled")
//    implementation("org.jetbrains.kotlin-wrappers:kotlin-css-js")
//}

