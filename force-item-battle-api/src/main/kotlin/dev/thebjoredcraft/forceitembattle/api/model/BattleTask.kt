package dev.thebjoredcraft.forceitembattle.api.model

import org.bukkit.Material
import org.bukkit.inventory.ItemStack

interface BattleTask {
    val item: Material
    var skipped: Boolean
    var completed: Boolean

    var completedAfter: Long
    var completedBy: String

    fun edit(block: BattleTask.() -> BattleTask)
}