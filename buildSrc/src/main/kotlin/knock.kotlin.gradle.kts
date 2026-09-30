import com.diffplug.gradle.spotless.SpotlessExtension
import org.jetbrains.kotlin.gradle.dsl.JvmDefaultMode
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("knock.java")
    kotlin("jvm")
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }

    compilerOptions {
        freeCompilerArgs = listOf(
            "-Xjdk-release=1.8",
            // Suppress deprecation warnings because we may still reference and test deprecated members.
            "-Xwarning-level=DEPRECATION:disabled",
            // Generated `validity()` implementations call `toInt()` on values that are already `Int`.
            "-Xwarning-level=REDUNDANT_CALL_OF_CONVERSION_METHOD:disabled",
        )
        jvmTarget.set(JvmTarget.JVM_1_8)
        jvmDefault.set(JvmDefaultMode.NO_COMPATIBILITY)
        languageVersion.set(KotlinVersion.KOTLIN_2_2)
        apiVersion.set(KotlinVersion.KOTLIN_2_2)
        coreLibrariesVersion = "2.2.0"
    }
}

tasks.named<KotlinCompile>("compileTestKotlin") {
    compilerOptions {
        freeCompilerArgs = freeCompilerArgs.get().map { if (it == "-Xjdk-release=1.8") "-Xjdk-release=17" else it }
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

configure<SpotlessExtension> {
    kotlin {
        // Match the ktfmt version used to format generated code to avoid formatting churn.
        ktfmt("0.61").kotlinlangStyle()
        toggleOffOn()
    }
}

tasks.withType<Test>().configureEach {
    systemProperty("junit.jupiter.execution.parallel.enabled", true)
    systemProperty("junit.jupiter.execution.parallel.mode.default", "concurrent")
}
