plugins {
    id("com.example.toysapp.convention.android.library")
}

android {
    namespace = "com.example.toysapp.logcat_logger"
}

dependencies {
    implementation(projects.lib.logger)
}
