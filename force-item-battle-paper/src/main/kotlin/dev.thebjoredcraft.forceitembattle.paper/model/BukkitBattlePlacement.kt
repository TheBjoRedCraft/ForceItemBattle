package dev.thebjoredcraft.forceitembattle.paper.model

import dev.thebjoredcraft.forceitembattle.api.model.BattlePlacement
import dev.thebjoredcraft.forceitembattle.api.model.BattleTask
import it.unimi.dsi.fastutil.objects.ObjectList

class BukkitBattlePlacement(
    override val placement: Int,
    override val succeededTasks: ObjectList<BattleTask>
): BattlePlacement {

}