package dev.thebjoredcraft.forceitembattle.paper.manager

import com.google.auto.service.AutoService
import dev.thebjoredcraft.forceitembattle.core.ForceItemManager
import dev.thebjoredcraft.forceitembattle.core.gameManager
import dev.thebjoredcraft.forceitembattle.paper.model.BukkitBattleTask
import dev.thebjoredcraft.forceitembattle.paper.model.BukkitBattleTeam
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap
import it.unimi.dsi.fastutil.objects.ObjectArraySet
import it.unimi.dsi.fastutil.objects.ObjectSet
import net.kyori.adventure.util.Services.Fallback
import org.bukkit.Material
import java.util.*

@AutoService(ForceItemManager::class)
class BukkitForceItemManager(): ForceItemManager, Fallback {
    private val items: ObjectSet<Material> = ObjectArraySet()
    private val currentItems = Object2ObjectOpenHashMap<BukkitBattleTeam, BukkitBattleTask>()

    override suspend fun loadItems() {
        items.addAll(Material.entries.filter { it.isItem })
    }

    override suspend fun getCurrentItem(uuid: UUID): Material? {
        return currentItems.get()
    }

    override suspend fun getNewItem(uuid: UUID): Material? {
        val difficulty = gameManager.getBattle()?.configuration?.difficulty ?: return null


    }

    override suspend fun markAsFinished(skipped: Boolean, completer: String) {
        TODO("Not yet implemented")
    }

    override suspend fun isOverworldItem(item: Material): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun isNetherItem(item: Material): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun isEndItem(item: Material): Boolean {
        TODO("Not yet implemented")
    }
}