plugins {
    `kotlin-dsl`
}

group = "com.example.toysapp.buildlogic.convention"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    compileOnly(libs.gradle.plugin.android)
    compileOnly(libs.gradle.plugin.kotlin)
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "com.example.toysapp.convention.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "com.example.toysapp.convention.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("jvmLibrary") {
            id = "com.example.toysapp.convention.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }
    }
}
