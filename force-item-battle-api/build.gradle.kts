plugins {
    kotlin("jvm")
    libs.plugins.plugin.yml
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
    compileOnly(libs.paper.api)
}

kotlin {
    jvmToolchain(21)
}