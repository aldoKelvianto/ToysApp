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
        register("androidFeature") {
            id = "nowinandroid.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
    }
}
