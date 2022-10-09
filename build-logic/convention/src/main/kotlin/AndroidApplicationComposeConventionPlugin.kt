import com.android.build.api.dsl.ApplicationExtension
import com.example.toysapp.buildlogic.convention.configureAndroidCompose
import com.example.toysapp.buildlogic.convention.configureBuildTypes
import com.example.toysapp.buildlogic.convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }
            val extension: ApplicationExtension = extensions.getByType<ApplicationExtension>()
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            with(extension) {
                configureAndroidCompose(this)
                configure<ApplicationExtension> {
                    configureKotlinAndroid(this)
                }
                configureBuildTypes()

                val targetSdkVersion = libs.findVersion("androidTargetSdk").get().toString().toInt()
                defaultConfig.targetSdk = targetSdkVersion

                packagingOptions {
                    resources {
                        excludes.add("/META-INF/{AL2.0,LGPL2.1}")
                    }
                }
            }
        }
    }

}
