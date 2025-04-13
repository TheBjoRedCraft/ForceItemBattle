package dev.thebjoredcraft.forceitembattle.api.model

import it.unimi.dsi.fastutil.objects.ObjectList
import java.util.UUID

interface BattleTeam {
    var size: Int
    val players: ObjectList<BattlePlayer>
    var skipsRemaining: Int

    fun hasPlayer(player: BattlePlayer): Boolean
    fun hasPlayer(uuid: UUID): Boolean

    fun update(action: BattleTeam.() -> Unit)
}