package dev.thebjoredcraft.forceitembattle.paper.model

import dev.thebjoredcraft.forceitembattle.api.model.BattlePlayer
import dev.thebjoredcraft.forceitembattle.api.type.BattleRole
import java.util.*

class BukkitBattlePlayer(
    override val uuid: UUID,
    override var role: BattleRole = BattleRole.NONE
): BattlePlayer {

}