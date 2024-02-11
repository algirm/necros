import id.northbit.gradle.setupAndroidLibrary

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.gradleUtil)
//    alias(libs.plugins.sqlDelight)
}
setupAndroidLibrary()
android {
    namespace = "id.northbit.necros.core.data"
}
kotlin {
    androidTarget()
    jvm()
    applyDefaultHierarchyTemplate()
    
    targets.forEach { 
        println("bosque ${it.name}")
    }
    sourceSets {
        val commonMain by getting
        val androidMain by getting
        val nonAndroid by creating
        val testing by creating
        
        nonAndroid.dependsOn(commonMain)
        testing.dependsOn(commonMain)
        androidMain.dependsOn(testing)
        
        jvmMain.dependencies {
            implementation(libs.sqldelight.sqlite.driver)
        }
    }
}