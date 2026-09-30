import com.diffplug.gradle.spotless.SpotlessExtension
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

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
            "-Xjvm-default=all",
            "-Xjdk-release=1.8",
            // Suppress deprecation warnings because we may still reference and test deprecated members.
            "-Xsuppress-warning=DEPRECATION",
        )
        jvmTarget.set(JvmTarget.JVM_1_8)
        languageVersion.set(KotlinVersion.KOTLIN_2_0)
        apiVersion.set(KotlinVersion.KOTLIN_2_0)
        coreLibrariesVersion = "2.0.0"
    }
}

configure<SpotlessExtension> {
    kotlin {
        ktfmt().kotlinlangStyle()
        toggleOffOn()
    }
}

tasks.withType<Test>().configureEach {
    systemProperty("junit.jupiter.execution.parallel.enabled", true)
    systemProperty("junit.jupiter.execution.parallel.mode.default", "concurrent")
}
