plugins {
    id("com.example.toysapp.convention.jvm.library")
}

dependencies {
    implementation(projects.lib.logger)
    testImplementation(libs.junit)
}
