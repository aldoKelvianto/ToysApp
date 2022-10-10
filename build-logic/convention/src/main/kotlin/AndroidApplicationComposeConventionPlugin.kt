import com.android.build.api.dsl.ApplicationExtension
import com.example.toysapp.buildlogic.convention.configureAndroidCompose
import com.example.toysapp.buildlogic.convention.configureBuildTypes
import com.example.toysapp.buildlogic.convention.configureDefaultConfigForApplication
import com.example.toysapp.buildlogic.convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }
            val extension = extensions.getByType<ApplicationExtension>()
            configureDefaultConfigForApplication()

            with(extension) {
                configureAndroidCompose(this)
                configureKotlinAndroid(this)
                configureBuildTypes()
                packagingOptions {
                    resources {
                        excludes.add("/META-INF/{AL2.0,LGPL2.1}")
                    }
                }
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
                add("implementation", libs.findBundle("compose").get())
                add("testImplementation", libs.findLibrary("junit").get())
                add("androidTestImplementation", libs.findLibrary("androidJunit").get())
                add("androidTestImplementation", libs.findLibrary("androidEspresso").get())
            }
        }
    }

}
