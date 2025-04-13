package dev.thebjoredcraft.forceitembattle.paper.manager

import com.google.auto.service.AutoService
import dev.thebjoredcraft.forceitembattle.api.model.Battle
import dev.thebjoredcraft.forceitembattle.core.GameManager
import net.kyori.adventure.util.Services.Fallback

@AutoService(GameManager::class)
class BukkitGameManager(): GameManager, Fallback {
    val battle: Battle? = null

    override suspend fun start() {
        TODO("Not yet implemented")
    }

    override suspend fun pause() {
        TODO("Not yet implemented")
    }

    override suspend fun resume() {
        TODO("Not yet implemented")
    }

    override suspend fun stop() {
        TODO("Not yet implemented")
    }

    override suspend fun isRunning(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun isPaused(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getBattle(): Battle? {
        TODO("Not yet implemented")
    }
}