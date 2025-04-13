package dev.thebjoredcraft.forceitembattle.core

import dev.thebjoredcraft.forceitembattle.api.model.Battle
import net.kyori.adventure.util.Services

interface GameManager {
    suspend fun start()
    suspend fun pause()
    suspend fun resume()
    suspend fun stop()

    suspend fun isRunning(): Boolean
    suspend fun isPaused(): Boolean

    suspend fun getBattle(): Battle?

    companion object {
        val INSTANCE: GameManager = Services.serviceWithFallback(GameManager::class.java).orElseThrow { IllegalStateException("There is no fallback service for ${this::class.java.name} available.") }
    }
}

val gameManager get() = GameManager.INSTANCE