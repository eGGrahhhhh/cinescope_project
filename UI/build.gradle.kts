plugins {
    id("java")
    id("io.qameta.allure") version "2.12.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.codeborne:selenide:7.7.3")
    implementation("org.junit.jupiter:junit-jupiter:5.10.0")
    //implementation("io.github.bonigarcia:webdrivermanager:5.9.2")
    //implementation("org.slf4j:slf4j-simple:2.0.16")
    implementation("ch.qos.logback:logback-classic:1.5.16")

    runtimeOnly("org.aspectj:aspectjweaver:1.9.23")
    testImplementation("io.qameta.allure:allure-selenide:2.29.0")
    testImplementation("io.qameta.allure:allure-junit5:2.29.0")
    testImplementation("io.qameta.allure:allure-java-commons:2.29.0")
    testImplementation("io.qameta.allure:allure-rest-assured:2.29.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

extensions.findByName("buildScan")?.withGroovyBuilder {
    setProperty("termsOfServiceUrl", "https://gradle.com/terms-of-service")
    setProperty("termsOfServiceAgree", "yes")
}