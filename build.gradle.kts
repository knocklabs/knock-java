plugins {
    id("org.jetbrains.dokka-javadoc") version "2.2.0" apply false
}

repositories {
    mavenCentral()
}

allprojects {
    group = "app.knock.api"
    version = "1.0.0" // x-release-please-version

    // Dokka's isolated build-tool classpaths otherwise resolve Jackson and jsoup versions with known
    // vulnerabilities. This doesn't affect the SDK's published or test dependencies.
    configurations.matching { it.name.startsWith("dokka") }.configureEach {
        resolutionStrategy.eachDependency {
            if (requested.group == "com.fasterxml.jackson" || requested.group.startsWith("com.fasterxml.jackson.")) {
                // Jackson annotations uses a two-component version starting with 2.20.
                useVersion(if (requested.name == "jackson-annotations") "2.22" else "2.22.3")
                because("Dokka's build-only Jackson classpath must use a secure aligned release")
            } else if (requested.group == "org.jsoup" && requested.name == "jsoup") {
                useVersion("1.23.2")
                because("Dokka's build-only jsoup classpath must use a secure release")
            }
        }
    }
}

subprojects {
    apply(plugin = "org.jetbrains.dokka-javadoc")
}
