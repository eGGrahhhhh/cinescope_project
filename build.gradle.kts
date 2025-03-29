import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    id("io.qameta.allure") version "2.12.0"
}

repositories {
    mavenCentral()
}

allprojects {
    apply(plugin = "io.qameta.allure")

    repositories {
        mavenCentral()
    }


    tasks.withType<JavaCompile> { //tasks.withType<JavaCompile>().configureEach
        options.encoding = "UTF-8"
    }

    tasks.withType<Test> {
        useJUnitPlatform()
        systemProperty("allure.results.directory", rootProject.file("allure-results"))

        testLogging {
            showStandardStreams = true
            events("started", "skipped", "passed", "failed")

            exceptionFormat = TestExceptionFormat.FULL
        }
        outputs.upToDateWhen { false }
    }

    extensions.findByName("buildScan")?.withGroovyBuilder {
        setProperty("termsOfServiceUrl", "https://gradle.com/terms-of-service")
        setProperty("termsOfServiceAgree", "yes")
    }
}