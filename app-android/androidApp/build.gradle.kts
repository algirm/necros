plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
//    id("org.jetbra")
}
android {
    namespace = "id.northbit.necros"
    compileSdk = libs.versions.androidCompileSdk.get().toInt()

//    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
//    sourceSets["main"].res.srcDirs("src/androidMain/res")
//    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "id.northbit.necros"
        minSdk = libs.versions.androidMinSdk.get().toInt()
        targetSdk = libs.versions.androidTargetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
//    buildFeatures {
//        compose = true
//    }
//    composeOptions {
//        kotlinCompilerExtensionVersion = "1.5.0"
//    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
//    dependencies {
//        debugImplementation(libs.compose.ui.tooling)
//    }
}
dependencies {
    implementation(projects.shared)
    implementation(projects.core.ui.compose)
    implementation(projects.core.data)
    implementation(projects.core.database)
    
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.decompose)
    implementation(libs.koin.core)
    implementation(libs.koin.android)

//    debugImplementation(libs.compose.ui.tooling)
//    implementation(libs.compose.ui.tooling.preview)
}
 