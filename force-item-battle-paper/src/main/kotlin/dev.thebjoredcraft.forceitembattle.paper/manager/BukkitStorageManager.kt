package dev.thebjoredcraft.forceitembattle.paper.manager

import com.google.auto.service.AutoService
import dev.thebjoredcraft.forceitembattle.core.StorageManager
import net.kyori.adventure.util.Services.Fallback

@AutoService(StorageManager::class)
class BukkitStorageManager(): StorageManager, Fallback {
    override suspend fun load() {
        TODO("Not yet implemented")
    }

    override suspend fun save() {
        TODO("Not yet implemented")
    }
}