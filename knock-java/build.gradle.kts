import org.jetbrains.dokka.gradle.DokkaExtension

plugins {
    id("knock.kotlin")
    id("knock.publish")
}

dependencies {
    api(project(":knock-java-client-okhttp"))
}

// Dokka's Javadoc format doesn't support multi-module aggregation, so document the sources of all the
// projects in this project's Javadoc directly.
configure<DokkaExtension> {
    dokkaSourceSets.named("main") {
        sourceRoots.from(
            project(":knock-java-core").layout.projectDirectory.dir("src/main/kotlin"),
            project(":knock-java-client-okhttp").layout.projectDirectory.dir("src/main/kotlin"),
        )
    }
}
