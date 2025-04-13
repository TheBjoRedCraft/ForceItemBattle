package dev.thebjoredcraft.forceitembattle.core

import dev.thebjoredcraft.forceitembattle.api.model.BattlePlacement
import it.unimi.dsi.fastutil.objects.Object2ObjectMap
import java.util.UUID

interface PlacementManager {
    fun getPlacement(uuid: UUID): BattlePlacement
    fun updatePlacement(uuid: UUID, placement: BattlePlacement)

    fun getAllPlacements(): Object2ObjectMap<UUID, BattlePlacement>
}