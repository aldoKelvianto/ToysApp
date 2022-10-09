plugins {
    id("com.example.toysapp.convention.jvm.library")
}

dependencies {
    implementation(projects.lib.logger)
    implementation(libs.apache.commons.codec)
    implementation(libs.koin.core)
}
