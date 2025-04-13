package dev.thebjoredcraft.forceitembattle.core

import net.kyori.adventure.util.Services
import org.bukkit.Material
import java.util.UUID

interface ForceItemManager {
    suspend fun loadItems()

    suspend fun isOverworldItem(item: Material): Boolean
    suspend fun isNetherItem(item: Material): Boolean
    suspend fun isEndItem(item: Material): Boolean

    suspend fun getCurrentItem(uuid: UUID): Material?
    suspend fun getNewItem(uuid: UUID): Material?

    suspend fun markAsFinished(skipped: Boolean, completer: String)

    companion object {
        val INSTANCE: ForceItemManager = Services.serviceWithFallback(ForceItemManager::class.java).orElseThrow { IllegalStateException("There is no fallback service for ${this::class.java.name} available.") }
    }
}

val forceItemManager get() = ForceItemManager.INSTANCE