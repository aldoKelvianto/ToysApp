package com.example.toysapp.buildlogic.convention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

internal fun Project.configureAndroidCompose(
    applicationExtension: ApplicationExtension
) {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

    applicationExtension.apply {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion =
                libs.findVersion("androidComposeCompiler").get().toString()
        }
    }
}

internal fun Project.configureAndroidCompose(
    applicationExtension: LibraryExtension
) {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

    applicationExtension.apply {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion =
                libs.findVersion("androidComposeCompiler").get().toString()
        }
    }
}
