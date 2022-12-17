plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = AppConfigs.presentationName
    compileSdk = AppConfigs.compileSdk

    defaultConfig {
        minSdk = AppConfigs.minSdk
        targetSdk = AppConfigs.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
    implementation(project(":domain"))
    implementation(AppDependencies.ANDROIDX_CORE_KTX)
    implementation(AppDependencies.ANDROIDX_APPCOMPAT)
    implementation(AppDependencies.MATERIAL)
    implementation(AppDependencies.DAGGER_HILT)
    kapt(AppDependencies.DAGGER_HILT_COMPILER)
    implementation(AppDependencies.ANDROID_VIEWMODEL_KTX)
    implementation(AppDependencies.ANDROID_FRAGMENT_KTX)
    implementation(AppDependencies.COROUTINE)

    testImplementation(TestDependencies.JUNIT)
    androidTestImplementation(TestDependencies.ANDROIDX_TEST)
    androidTestImplementation(TestDependencies.ANDROIDX_ESPRESSO)
}