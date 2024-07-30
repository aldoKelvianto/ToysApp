plugins {
    id("com.example.toysapp.convention.jvm.library")
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    implementation(projects.lib.logger)
    testImplementation(libs.junit5)
}
