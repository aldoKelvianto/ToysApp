import com.android.build.api.dsl.LibraryExtension
import com.example.toysapp.buildlogic.convention.configureBuildTypes
import com.example.toysapp.buildlogic.convention.configureDefaultConfigForLibrary
import com.example.toysapp.buildlogic.convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }
            val extension = extensions.getByType<LibraryExtension>()
            configureDefaultConfigForLibrary()
            with(extension) {
                configureKotlinAndroid(this)
                configureBuildTypes()
            }
        }
    }
}
