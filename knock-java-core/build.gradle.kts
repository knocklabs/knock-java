plugins {
    id("knock.kotlin")
    id("knock.publish")
}

configurations.all {
    resolutionStrategy {
        // Compile and test against a lower Jackson version to ensure we're compatible with it.
        // We publish with a higher version (see below) to ensure users depend on a secure version by default.
        force("com.fasterxml.jackson.core:jackson-core:2.13.4")
        force("com.fasterxml.jackson.core:jackson-databind:2.13.4")
        force("com.fasterxml.jackson.core:jackson-annotations:2.13.4")
        force("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.13.4")
        force("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.13.4")
        force("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.4")
    }
}

dependencies {
    api("com.fasterxml.jackson.core:jackson-core:2.22.3")
    api("com.fasterxml.jackson.core:jackson-databind:2.22.3")
    api("com.google.errorprone:error_prone_annotations:2.50.0")

    implementation("com.fasterxml.jackson.core:jackson-annotations:2.22")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.22.3")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.22.3")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.22.3")
    implementation("org.apache.httpcomponents.core5:httpcore5:5.4.4")
    implementation("org.apache.httpcomponents.client5:httpclient5:5.6.4")

    testImplementation(kotlin("test"))
    testImplementation(project(":knock-java-client-okhttp"))
    testImplementation("org.wiremock:wiremock-standalone:3.13.2")
    testImplementation("org.assertj:assertj-core:3.27.7")
    testImplementation("org.junit.jupiter:junit-jupiter-api:6.1.3")
    testImplementation("org.junit.jupiter:junit-jupiter-params:6.1.3")
    testImplementation("org.junit-pioneer:junit-pioneer:2.3.0")
    testImplementation("org.mockito:mockito-core:5.24.0")
    testImplementation("org.mockito:mockito-junit-jupiter:5.24.0")
    testImplementation("org.mockito.kotlin:mockito-kotlin:6.4.0")
}
