import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    id("java")
    id("io.freefair.lombok") version "8.4"
    // id("io.qameta.allure") version "2.12.0"

}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.projectlombok:lombok:1.18.34")
    implementation("org.junit.jupiter:junit-jupiter:5.10.0")
    implementation("io.rest-assured:rest-assured:5.5.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.2")
    implementation("com.github.javafaker:javafaker:1.0.2")
    implementation("org.slf4j:slf4j-simple:2.0.16")

    implementation("com.codeborne:selenide:7.7.3")

    runtimeOnly("org.aspectj:aspectjweaver:1.9.23")
    implementation("io.qameta.allure:allure-selenide:2.29.1")
    implementation("io.qameta.allure:allure-junit5:2.29.1")
    implementation("io.qameta.allure:allure-java-commons:2.29.1")
    implementation("io.qameta.allure:allure-rest-assured:2.29.1")

}

tasks.test {
    useJUnitPlatform()

    testLogging {
        showStandardStreams = true
        events("started", "skipped", "passed", "failed")
        exceptionFormat = TestExceptionFormat.FULL
    }
    outputs.upToDateWhen { false }
}