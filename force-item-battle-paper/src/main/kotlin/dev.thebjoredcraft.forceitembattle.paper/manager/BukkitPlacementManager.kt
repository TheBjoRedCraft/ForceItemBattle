package dev.thebjoredcraft.forceitembattle.paper.manager

import com.google.auto.service.AutoService
import dev.thebjoredcraft.forceitembattle.api.model.BattlePlacement
import dev.thebjoredcraft.forceitembattle.core.PlacementManager
import it.unimi.dsi.fastutil.objects.Object2ObjectMap
import net.kyori.adventure.util.Services.Fallback
import java.util.*

@AutoService(PlacementManager::class)
class BukkitPlacementManager(): PlacementManager, Fallback {
    override suspend fun getPlacement(uuid: UUID): BattlePlacement {
        TODO("Not yet implemented")
    }

    override suspend fun updatePlacement(uuid: UUID, placement: BattlePlacement) {
        TODO("Not yet implemented")
    }

    override fun getAllPlacements(): Object2ObjectMap<UUID, BattlePlacement> {
        TODO("Not yet implemented")
    }
}