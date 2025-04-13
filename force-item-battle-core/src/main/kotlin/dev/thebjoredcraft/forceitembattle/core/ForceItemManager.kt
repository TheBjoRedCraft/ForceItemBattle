package dev.thebjoredcraft.forceitembattle.core

import net.kyori.adventure.util.Services
import org.bukkit.Material
import java.util.UUID

interface ForceItemManager {
    suspend fun loadItems()

    suspend fun isOverworldItem(item: Material)
    suspend fun isNetherItem(item: Material)
    suspend fun isEndItem(item: Material)

    suspend fun getCurrentItem(uuid: UUID)
    suspend fun getNewItem(uuid: UUID)

    companion object {
        val INSTANCE: ForceItemManager = Services.serviceWithFallback(ForceItemManager::class.java).orElseThrow { IllegalStateException("There is no fallback service for ${this::class.java.name} available.") }
    }
}

val forceItemManager get() = ForceItemManager.INSTANCE