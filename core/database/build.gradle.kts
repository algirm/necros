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
    iosCompat()
}

setupAndroidLibrary()

android {
    namespace = "id.northbit.necros.core.database"
}

kotlin {
    jvm {
        compilations {
            val anjingKu by compilations.creating {
                defaultSourceSet { 
//                    dependsOn()
                }
            }
        }  
    }
    sourceSets {
        maybeCreate("kucingMuMain")
        val kucingKu by creating {
            create("main").dependencies { 
                
            }
        }
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
//    targets.configureEach {
//        compilations.configureEach {
//            compilerOptions.configure {
//                freeCompilerArgs.add("-Xexpect-actual-classes")
//            }
//        }
//    }
}

sqldelight {
    databases {
        create("AppDatabase") {
            packageName.set("id.northbit.necros.core.database")
        }
    }
}



