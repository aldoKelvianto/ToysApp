import com.android.build.api.dsl.ApplicationExtension
import com.example.toysapp.buildlogic.convention.configureAndroidCompose
import com.example.toysapp.buildlogic.convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }
            val extension = extensions.getByType<ApplicationExtension>()
            with(extension) {
                configureAndroidCompose(this)
                configure<ApplicationExtension> {
                    configureKotlinAndroid(this)
                }
                defaultConfig.targetSdk = 32
            }
        }
    }

}
