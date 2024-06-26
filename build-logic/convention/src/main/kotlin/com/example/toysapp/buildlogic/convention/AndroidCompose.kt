package com.example.toysapp.buildlogic.convention

import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeCompilerGradlePluginExtension

internal fun Project.configureAndroidCompose() {
    val composeCompiler = extensions.getByType<ComposeCompilerGradlePluginExtension>()
    composeCompiler.apply {
        enableStrongSkippingMode.set(true)
        reportsDestination.set(layout.buildDirectory.dir("compose_compiler"))
        stabilityConfigurationFile.set(rootProject.layout.projectDirectory.file("stability_config.conf"))
    }
}
