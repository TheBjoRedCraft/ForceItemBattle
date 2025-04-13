package dev.thebjoredcraft.forceitembattle.core

import dev.thebjoredcraft.forceitembattle.api.model.BattlePlacement
import it.unimi.dsi.fastutil.objects.Object2ObjectMap
import net.kyori.adventure.util.Services
import java.util.UUID

interface PlacementManager {
    suspend fun getPlacement(uuid: UUID): BattlePlacement
    suspend fun updatePlacement(uuid: UUID, placement: BattlePlacement)

    fun getAllPlacements(): Object2ObjectMap<UUID, BattlePlacement>

    companion object {
        val INSTANCE: PlacementManager = Services.serviceWithFallback(PlacementManager::class.java).orElseThrow { IllegalStateException("There is no fallback service for ${this::class.java.name} available.") }
    }
}

val placementManager get() = PlacementManager.INSTANCE