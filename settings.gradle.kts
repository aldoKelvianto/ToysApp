pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

plugins {
    // From: https://docs.gradle.org/current/userguide/version_catalogs.html
    // You cannot use a plugin declared in a version catalog in your settings file or settings plugin.
    // alias(libs.plugins.build.health)
    id("com.autonomousapps.build-health") version "2.8.2"

    // From: https://github.com/autonomousapps/dependency-analysis-gradle-plugin/wiki/Adding-to-your-project
    id("org.jetbrains.kotlin.jvm") version "2.1.10" apply false
    id("com.android.application") version "8.8.1" apply false
    id("org.jetbrains.kotlin.android") version "2.1.10" apply false
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "ToysApp"
include(":app")
include(":feature:feature-toys")
include(":feature:feature-payment")
include(":android-lib:logcat-logger")
include(":android-lib:navigation")
include(":android-lib:base")
include(":lib:logger")
include(":lib:console-logger")
include(":lib:crypto")
