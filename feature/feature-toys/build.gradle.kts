plugins {
    id("com.example.toysapp.convention.android.feature.compose")
}

android {
    namespace = "com.example.toysapp.feature_toys"
}

dependencies {
    implementation(projects.androidLib.navigation)
    implementation(projects.androidLib.base)
    implementation(projects.lib.logger)
    implementation(libs.koin.android)
    implementation(libs.bundles.compose)
}
