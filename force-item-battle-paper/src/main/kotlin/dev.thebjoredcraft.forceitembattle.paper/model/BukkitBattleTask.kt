package dev.thebjoredcraft.forceitembattle.paper.model

import dev.thebjoredcraft.forceitembattle.api.model.BattleTask
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class BukkitBattleTask (
    override val item: Material,
    override val skipped: Boolean,
    override val completed: Boolean,
    override val completedAfter: Long,
    override val completedBy: String
): BattleTask {

}