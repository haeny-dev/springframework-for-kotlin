import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.20"
    id("me.champeau.gradle.jmh") version "0.5.3"
    id("org.jetbrains.dokka") version "1.8.20"
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0"
}

group = "com.haeny"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.8.20")
    implementation("org.reflections:reflections:0.10.2")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

jmh {
    threads = 1
    fork = 1
    warmupIterations = 1
    iterations = 1
}
