import com.android.build.api.dsl.ApplicationExtension
import com.example.toysapp.buildlogic.convention.configureAndroidCompose
import com.example.toysapp.buildlogic.convention.configureBuildTypes
import com.example.toysapp.buildlogic.convention.configureDefaultConfig
import com.example.toysapp.buildlogic.convention.configureKotlin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("com.jraska.module.graph.assertion")
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            extensions.configure<ApplicationExtension> {
                configureDefaultConfig(this)
                configureBuildTypes(this)
                configureAndroidCompose()
                configureKotlin(this)
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
                val composeBom = platform(libs.findLibrary("androidx-compose-bom").get())
                add("implementation", composeBom)
                add("implementation", libs.findBundle("compose").get())
                add("testImplementation", libs.findLibrary("junit").get())
                add("androidTestImplementation", libs.findLibrary("androidJunit").get())
                add("androidTestImplementation", libs.findLibrary("androidEspresso").get())
            }
        }
    }

}
