package dev.thebjoredcraft.forceitembattle.paper.model

import dev.thebjoredcraft.forceitembattle.api.model.BattleTask
import org.bukkit.inventory.ItemStack

class BukkitBattleTask (
    override val item: ItemStack,
    override val skipped: Boolean,
    override val completed: Boolean,
    override val completedAfter: Long,
    override val completedBy: String
): BattleTask {

}