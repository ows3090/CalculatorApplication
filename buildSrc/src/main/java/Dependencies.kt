object Versions{
    const val ANDROIDX_CORE_KTX = "1.7.0"
    const val ANDROIDX_APPCOMPAT = "1.5.1"
    const val MATERIAL = "1.7.0"
    const val TIMBER = "5.0.1"
    const val DAGGER_HILT = "2.44"
    const val ANDROID_VIEWMODEL_KTX = "2.5.1"
    const val ANDROID_FRAGMENT_KTX = "1.5.5"
    const val COROUTINE = "1.3.9"
}

object TestVersions{
    const val JUNIT = "4.13.2"
    const val ANDROIDX_TEST = "1.1.4"
    const val ANDROIDX_ESPRESSO = "3.5.0"
}

object AppDependencies{
    const val ANDROIDX_CORE_KTX = "androidx.core:core-ktx:${Versions.ANDROIDX_CORE_KTX}"
    const val ANDROIDX_APPCOMPAT = "androidx.appcompat:appcompat:${Versions.ANDROIDX_APPCOMPAT}"
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    const val TIMBER = "com.jakewharton.timber:timber:${Versions.TIMBER}"
    const val DAGGER_HILT = "com.google.dagger:hilt-android:${Versions.DAGGER_HILT}"
    const val DAGGER_HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.DAGGER_HILT}"
    const val ANDROID_VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.ANDROID_VIEWMODEL_KTX}"
    const val ANDROID_FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.ANDROID_FRAGMENT_KTX}"
    const val COROUTINE = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINE}"
}

object TestDependencies{
    const val JUNIT = "junit:junit:${TestVersions.JUNIT}"
    const val ANDROIDX_TEST = "androidx.test.ext:junit:${TestVersions.ANDROIDX_TEST}"
    const val ANDROIDX_ESPRESSO = "androidx.test.espresso:espresso-core:${TestVersions.ANDROIDX_ESPRESSO}"
}

