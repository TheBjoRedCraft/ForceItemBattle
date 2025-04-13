package dev.thebjoredcraft.forceitembattle.paper.model

import dev.thebjoredcraft.forceitembattle.api.model.BattlePlayer
import dev.thebjoredcraft.forceitembattle.api.model.BattleTeam
import it.unimi.dsi.fastutil.objects.ObjectList

class BukkitBattleTeam (
    override var size: Int,
    override val players: ObjectList<BattlePlayer>
): BattleTeam {
}