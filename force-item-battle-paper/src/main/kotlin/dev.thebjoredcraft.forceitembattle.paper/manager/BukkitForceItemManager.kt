package dev.thebjoredcraft.forceitembattle.paper.manager

import com.google.auto.service.AutoService
import dev.thebjoredcraft.forceitembattle.core.ForceItemManager
import it.unimi.dsi.fastutil.objects.ObjectArraySet
import it.unimi.dsi.fastutil.objects.ObjectSet
import net.kyori.adventure.util.Services.Fallback
import org.bukkit.Material
import java.util.*

@AutoService(ForceItemManager::class)
class BukkitForceItemManager(): ForceItemManager, Fallback {
    private val items: ObjectSet<Material> = ObjectArraySet()

    override suspend fun loadItems() {
        items.addAll(Material.entries.filter { it.isItem })
    }

    override suspend fun isOverworldItem(item: Material) {
        TODO("Not yet implemented")
    }

    override suspend fun isNetherItem(item: Material) {
        TODO("Not yet implemented")
    }

    override suspend fun isEndItem(item: Material) {
        TODO("Not yet implemented")
    }

    override suspend fun getCurrentItem(uuid: UUID) {
        TODO("Not yet implemented")
    }

    override suspend fun getNewItem(uuid: UUID) {

    }
}