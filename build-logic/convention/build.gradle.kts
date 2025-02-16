plugins {
    `kotlin-dsl`
}

group = "com.example.toysapp.buildlogic.convention"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

dependencies {
    compileOnly(libs.gradle.plugin.android)
    compileOnly(libs.gradle.plugin.kotlin)
    compileOnly(libs.gradle.plugin.compose.compiler)
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "com.example.toysapp.convention.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidFeatureCompose") {
            id = "com.example.toysapp.convention.android.feature.compose"
            implementationClass = "AndroidFeatureComposeConventionPlugin"
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
