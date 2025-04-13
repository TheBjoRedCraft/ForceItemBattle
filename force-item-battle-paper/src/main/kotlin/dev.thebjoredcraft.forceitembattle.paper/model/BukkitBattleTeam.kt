package dev.thebjoredcraft.forceitembattle.paper.model

import dev.thebjoredcraft.forceitembattle.api.model.BattlePlayer
import dev.thebjoredcraft.forceitembattle.api.model.BattleTeam
import dev.thebjoredcraft.forceitembattle.core.teamManager
import it.unimi.dsi.fastutil.objects.ObjectList
import java.util.*

class BukkitBattleTeam (
    override var size: Int,
    override val players: ObjectList<BattlePlayer>,
    override var skipsRemaining: Int
): BattleTeam {
    override fun hasPlayer(player: BattlePlayer): Boolean {
        return players.contains(player)
    }

    override fun hasPlayer(uuid: UUID): Boolean {
        return players.any { it.uuid == uuid }
    }

    override fun update(action: BattleTeam.() -> Unit) {
        teamManager.editTeam(this, action)
    }
}