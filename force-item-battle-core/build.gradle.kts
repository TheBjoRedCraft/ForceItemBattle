plugins {
    kotlin("jvm")
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
    api(project(":force-item-battle-api"))

    compileOnly(libs.paper.api)
}

kotlin {
    jvmToolchain(21)
}