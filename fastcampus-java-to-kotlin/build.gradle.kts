plugins {
    id("org.springframework.boot") version "3.2.3"
    java
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.spring") version "1.9.22"
    kotlin("plugin.jpa") version "1.9.22"
    // kotlin("plugin.noarg") version "1.9.22"
    // id("org.jetbrains.kotlin.plugin.allopen") version "1.9.22"
}

apply(plugin = "io.spring.dependency-management")

// noArg {
//     annotations("jakarta.persistence.Entity")
// }

// allOpen {
//     annotations(
//         "org.springframework.boot.autoconfigure.SpringBootApplication",
//         "org.springframework.transaction.annotation.Transactional"
//     )
// }

group = "org.example"
version = "1.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.h2database:h2")

    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}