import net.minecrell.pluginyml.paper.PaperPluginDescription

plugins {
    kotlin("jvm")
    id("com.gradleup.shadow") version "9.0.0-beta12"
    id("de.eldoria.plugin-yml.paper") version "0.7.0"
}

repositories {
    mavenCentral()
    gradlePluginPortal()

    maven {
        name = "papermc"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
}

paper {
    main = "dev.thebjoredcraft.forceitembattle.paper.ForceItemBattlePlugin"
    apiVersion = "1.21.4"
    name = "ForceItemBattle"
    version = "1.0.0-SNAPSHOT"
    description = "A plugin for the mini game force item battle, inspired by BastiGHG and his challenges"
    authors = listOf("TheBjoRedCraft")

    serverDependencies {
        register("CommandAPI") {
            required = true
            load = PaperPluginDescription.RelativeLoadOrder.BEFORE
        }
    }
}

dependencies {
    compileOnly(libs.paper.api)
    compileOnly(libs.commandapi.bukkit.kotlin)

    api(project(":force-item-battle-core"))
    implementation(libs.kotlinxCoroutines.core)
    implementation(libs.mccoroutine.folia.api)
    implementation(libs.mccoroutine.folia.core)
}

kotlin {
    jvmToolchain(21)
}