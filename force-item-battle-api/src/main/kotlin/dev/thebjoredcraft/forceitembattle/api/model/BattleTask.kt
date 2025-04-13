package dev.thebjoredcraft.forceitembattle.api.model

import org.bukkit.inventory.ItemStack

interface BattleTask {
    val item: ItemStack
    val skipped: Boolean
    val completed: Boolean

    val completedAfter: Long
    val completedBy: String
}