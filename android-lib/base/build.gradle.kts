plugins {
    id("com.example.toysapp.convention.android.library")
}

android {
    namespace = "com.example.base"
}

dependencies {
    implementation(libs.koin.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidJunit)
    androidTestImplementation(libs.androidEspresso)
}
