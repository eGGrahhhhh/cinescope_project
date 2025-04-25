import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    id("java")
    id("io.freefair.lombok") version "8.4"
    id("io.qameta.allure") version "2.12.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

allprojects {

    tasks.withType<Test> {
        useJUnitPlatform()
        systemProperties(System.getProperties().map { it.key.toString() to it.value.toString() }.toMap())
        testLogging {
            showStandardStreams = true
            events("started", "skipped", "passed", "failed")
            exceptionFormat = TestExceptionFormat.FULL
        }
        outputs.upToDateWhen { false }
    }

    tasks.withType<JavaCompile>().configureEach {
        options.encoding = "UTF-8"
    }

    extensions.findByName("buildScan")?.withGroovyBuilder {
        setProperty("termsOfServiceUrl", "https://gradle.com/terms-of-service")
        setProperty("termsOfServiceAgree", "yes")
    }
}