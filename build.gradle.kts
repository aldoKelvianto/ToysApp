plugins {
    alias(libs.plugins.module.graph.assertion) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.binary.compatibility.validator)
}
