package dev.thebjoredcraft.forceitembattle.api.model

import org.bukkit.Material
import org.bukkit.inventory.ItemStack

interface BattleTask {
    val item: Material
    val skipped: Boolean
    val completed: Boolean

    val completedAfter: Long
    val completedBy: String
}