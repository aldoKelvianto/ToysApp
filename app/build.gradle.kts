plugins {
    id("com.example.toysapp.convention.android.application.compose")
}

android {
    namespace = "com.example.toysapp"

    defaultConfig {
        applicationId = "com.example.toysapp"
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    implementation(libs.koin.android)
    implementation(projects.feature.featurePayment)
    implementation(projects.feature.featureToys)
    implementation(projects.lib.consoleLogger)
    implementation(projects.lib.crypto)
    implementation(projects.lib.logger)
    implementation(projects.androidLib.logcatLogger)
    implementation(projects.androidLib.navigation)
}
