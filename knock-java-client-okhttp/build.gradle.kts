plugins {
    id("knock.kotlin")
    id("knock.publish")
}

dependencies {
    api(project(":knock-java-core"))

    implementation("com.squareup.okhttp3:okhttp-jvm:5.5.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.5.0")

    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:3.27.7")
}
