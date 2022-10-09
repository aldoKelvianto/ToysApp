package com.example.toysapp.buildlogic.convention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

internal fun Project.configureDefaultConfigForApplication() {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
    val targetSdkVersion = libs.findVersion("androidTargetSdk").get().toString().toInt()
    val extension = extensions.getByType<ApplicationExtension>()
    extension.defaultConfig {
        targetSdk = targetSdkVersion
    }
}

internal fun Project.configureDefaultConfigForLibrary() {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
    val targetSdkVersion = libs.findVersion("androidTargetSdk").get().toString().toInt()
    val extension = extensions.getByType<LibraryExtension>()
    extension.defaultConfig {
        targetSdk = targetSdkVersion
        consumerProguardFiles("consumer-rules.pro")
    }
}

internal fun ApplicationExtension.configureBuildTypes() {
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

internal fun LibraryExtension.configureBuildTypes() {
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

internal fun Project.configureKotlinAndroid(
    commonExtension: CommonExtension<*, *, *, *>,
) {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
    commonExtension.apply {
        val minSdkVersion = libs.findVersion("androidMinSdk").get().toString().toInt()
        defaultConfig {
            minSdk = minSdkVersion
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            vectorDrawables {
                useSupportLibrary = true
            }
        }

        val compileSdkVersion = libs.findVersion("androidCompileSdk").get().toString().toInt()
        compileSdk = compileSdkVersion

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }

        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }
}

fun CommonExtension<*, *, *, *>.kotlinOptions(block: KotlinJvmOptions.() -> Unit) {
    (this as ExtensionAware).extensions.configure("kotlinOptions", block)
}
