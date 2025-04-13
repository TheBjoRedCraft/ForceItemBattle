package dev.thebjoredcraft.forceitembattle.paper.model

import dev.thebjoredcraft.forceitembattle.api.model.BattleTask
import org.bukkit.Material

class BukkitBattleTask (
    override val item: Material,
    override var skipped: Boolean,
    override var completed: Boolean,
    override var completedAfter: Long,
    override var completedBy: String
): BattleTask {
    override fun edit(block: BattleTask.() -> BattleTask) {
        this.block()
    }
}