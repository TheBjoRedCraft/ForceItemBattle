plugins {
    kotlin("jvm") version "2.1.10"
}

allprojects {
    group = "dev.thebjoredcraft"
    version = "1.21.4-1.0.0-SNAPSHOT"
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

kotlin {
    jvmToolchain(21)
}