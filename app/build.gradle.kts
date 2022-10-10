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

moduleGraphAssert {
    maxHeight = 4
    allowed = arrayOf(
        ":.* -> :lib:.*",
        ":.* -> :android-lib:.*",
        ":feature:.* -> :lib:.*",
        ":feature:.* -> :android-lib:.*",
        ":app -> :feature:.*"
    )
    restricted = arrayOf(
        ":feature:.* -X> :feature:.*",
        ":android-lib:.* -X> :feature:.*",
        ":lib:.* -X> :feature:.*"
    )
    configurations = setOf("api", "implementation")
    assertOnAnyBuild =
        false // true value will run the assertions as part of any build without need to run the assert* tasks, false is default
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
