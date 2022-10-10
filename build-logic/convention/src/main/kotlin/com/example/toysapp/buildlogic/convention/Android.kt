package com.example.toysapp.buildlogic.convention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

internal fun Project.configureBuildTypes(extension: ApplicationExtension) {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
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
    }
}

internal fun Project.configureBuildTypes(extension: LibraryExtension) {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
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
        packagingOptions {
            resources {
                excludes.add("/META-INF/{AL2.0,LGPL2.1}")
            }
        }
    }
}

internal fun Project.configureDefaultConfig(extension: ApplicationExtension) {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
    with(extension) {
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

internal fun Project.configureDefaultConfig(extension: LibraryExtension) {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
    with(extension) {
        defaultConfig {
            val minSdkVersion = libs.findVersion("androidMinSdk").get().toString().toInt()
            val targetSdkVersion = libs.findVersion("androidTargetSdk").get().toString().toInt()

            minSdk = minSdkVersion
            targetSdk = targetSdkVersion
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            consumerProguardFiles("consumer-rules.pro")
            vectorDrawables {
                useSupportLibrary = true
            }
        }
    }
}
