package dev.thebjoredcraft.forceitembattle.api.model

import dev.thebjoredcraft.forceitembattle.api.type.BattleDifficulty

interface BattleConfiguration {
    var minTeamSize: Int
    var maxTeamSize: Int

    var gameTime: Long
    var difficulty: BattleDifficulty
    var skips: Int
}