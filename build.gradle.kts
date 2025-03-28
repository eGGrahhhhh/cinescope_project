import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    id("java")
    id("io.qameta.allure") version "2.12.0"
}

repositories {
    mavenCentral()
}

//dependencies {
//    testRuntimeOnly("org.aspectj:aspectjweaver:1.9.23")
//    implementation("io.qameta.allure:allure-junit5:2.29.1")
//    implementation("io.qameta.allure:allure-selenide:2.29.1")
//    implementation("io.qameta.allure:allure-java-commons:2.29.1")
//    implementation("io.qameta.allure:allure-rest-assured:2.29.1")
//}

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

    allure {
        version.set("2.12.0")
    }
}