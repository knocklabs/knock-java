plugins {
    id("knock.kotlin")
    id("java")
    application
}

dependencies {
    implementation(project(":knock-java"))
}

tasks.withType<JavaCompile>().configureEach {
    // Allow using more modern APIs, like `List.of` and `Map.of`, in examples.
    options.release.set(9)
}

application {
    mainClass = "com.knock.api.example.Main"
}
