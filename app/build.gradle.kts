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

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
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

    implementation(libs.bundles.compose)
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}
