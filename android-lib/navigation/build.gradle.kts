plugins {
    id("com.example.toysapp.convention.android.library")
}

android {
    namespace = "com.example.toysapp.navigation"
}

dependencies {
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidJunit)
    androidTestImplementation(libs.androidEspresso)
}
