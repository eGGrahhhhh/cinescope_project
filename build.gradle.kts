import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    id("io.qameta.allure") version "2.12.0"
}

repositories {
    mavenCentral()
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

allprojects {
    apply(plugin = "io.qameta.allure")

    tasks.withType<Test> {
        useJUnitPlatform()
        systemProperty("allure.results.directory", rootProject.file("allure-results"))

        testLogging {
            showStandardStreams = true
            events("started", "skipped", "failed")
            exceptionFormat = TestExceptionFormat.FULL
        }
    }
}