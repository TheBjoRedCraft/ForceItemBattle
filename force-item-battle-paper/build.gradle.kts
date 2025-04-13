plugins {
    kotlin("jvm")
    id("com.gradleup.shadow") version "9.0.0-beta12"
    libs.plugins.plugin.yml.paper
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

    compileOnly(libs.commandapi.bukkit.kotlin)

    implementation(libs.kotlinxCoroutines.core)
    implementation(libs.mccoroutine.folia.api)
    implementation(libs.mccoroutine.folia.core)


}

kotlin {
    jvmToolchain(21)
}