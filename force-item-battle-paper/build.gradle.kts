plugins {
    kotlin("jvm")
    id("com.gradleup.shadow") version "9.0.0-beta12"
}

repositories {
    mavenCentral()
    gradlePluginPortal()

    maven {
        name = "papermc"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
}

dependencies {
    compileOnly(project(":force-item-battle-core"))
    compileOnly(libs.paper.api)
}

kotlin {
    jvmToolchain(21)
}