package com.example.toysapp.buildlogic.convention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

internal fun Project.configureDefaultConfigForApplication() {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
    val extension = extensions.getByType<ApplicationExtension>()
    extension.defaultConfig {
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

internal fun Project.configureDefaultConfigForLibrary() {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
    val extension = extensions.getByType<LibraryExtension>()
    extension.defaultConfig {
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
