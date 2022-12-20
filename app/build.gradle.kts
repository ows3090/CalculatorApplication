plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = AppConfigs.appName
    compileSdk = AppConfigs.compileSdk

    defaultConfig {
        applicationId = AppConfigs.appName
        minSdk = AppConfigs.minSdk
        targetSdk = AppConfigs.targetSdk
        versionCode = AppConfigs.versionCode
        versionName = AppConfigs.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(project(":presentation"))
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(AppDependencies.MATERIAL)
    implementation(AppDependencies.TIMBER)
    implementation(AppDependencies.DAGGER_HILT)
    kapt(AppDependencies.DAGGER_HILT_COMPILER)

    implementation(AppDependencies.ANDROIDX_ROOM)
    kapt(AppDependencies.ANDROIDX_ROOM_COMPILER)
    implementation(AppDependencies.ANDROIDX_ROOM_KTX)
}