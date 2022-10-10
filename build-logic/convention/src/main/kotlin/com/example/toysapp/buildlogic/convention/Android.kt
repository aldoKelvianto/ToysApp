package com.example.toysapp.buildlogic.convention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

internal fun Project.configureApplicationExtensionForApplication() {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
    val extension = extensions.getByType<ApplicationExtension>()
    with(extension) {
        val compileSdkVersion = libs.findVersion("androidCompileSdk").get().toString().toInt()
        compileSdk = compileSdkVersion

        buildTypes {
            release {
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
        }

        defaultConfig {
            val minSdkVersion = libs.findVersion("androidMinSdk").get().toString().toInt()
            val targetSdkVersion = libs.findVersion("androidTargetSdk").get().toString().toInt()

            minSdk = minSdkVersion
            targetSdk = targetSdkVersion
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            vectorDrawables {
                useSupportLibrary = true
            }
        }
    }

}

internal fun Project.configureLibraryExtensionForApplication() {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
    val extension = extensions.getByType<LibraryExtension>()
    with(extension) {
        val compileSdkVersion = libs.findVersion("androidCompileSdk").get().toString().toInt()
        compileSdk = compileSdkVersion

        buildTypes {
            release {
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
        }

        defaultConfig {
            val minSdkVersion = libs.findVersion("androidMinSdk").get().toString().toInt()
            val targetSdkVersion = libs.findVersion("androidTargetSdk").get().toString().toInt()

            minSdk = minSdkVersion
            targetSdk = targetSdkVersion
            consumerProguardFiles("consumer-rules.pro")
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            vectorDrawables {
                useSupportLibrary = true
            }
        }
    }

}
