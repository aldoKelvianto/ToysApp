import com.android.build.api.dsl.LibraryExtension
import com.example.toysapp.buildlogic.convention.configureBuildTypes
import com.example.toysapp.buildlogic.convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }
            val extension = extensions.getByType<LibraryExtension>()
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            with(extension) {
                configureKotlinAndroid(this)
                configureBuildTypes()
                val targetSdkVersion = libs.findVersion("androidTargetSdk").get().toString().toInt()
                with(defaultConfig) {
                    targetSdk = targetSdkVersion
                    consumerProguardFiles("consumer-rules.pro")
                }
            }
        }
    }
}
