package dev.thebjoredcraft.forceitembattle.core

import net.kyori.adventure.util.Services

interface StorageManager {
    suspend fun load()
    suspend fun save()

    companion object {
        val INSTANCE: StorageManager = Services.serviceWithFallback(StorageManager::class.java).orElseThrow { IllegalStateException("There is no fallback service for ${this::class.java.name} available.") }
    }
}

val storageManager get() = StorageManager.INSTANCE