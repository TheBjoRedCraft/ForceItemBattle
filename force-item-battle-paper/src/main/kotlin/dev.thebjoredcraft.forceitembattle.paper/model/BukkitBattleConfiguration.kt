package dev.thebjoredcraft.forceitembattle.paper.model

import dev.thebjoredcraft.forceitembattle.api.model.BattleConfiguration
import dev.thebjoredcraft.forceitembattle.api.type.BattleDifficulty

class BukkitBattleConfiguration (
    override var minTeamSize: Int,
    override var maxTeamSize: Int,
    override var gameTime: Long,
    override var difficulty: BattleDifficulty,
    override var skips: Int
): BattleConfiguration {

}