package dev.thebjoredcraft.forceitembattle.api

import dev.thebjoredcraft.forceitembattle.api.model.Battle
import dev.thebjoredcraft.forceitembattle.api.model.BattleConfiguration

interface ForceItemBattleApi {
    fun isRunning(): Boolean
    fun getBattle(): Battle?

    fun startBattle(config: BattleConfiguration)
    fun pauseBattle()
    fun resumeBattle()
    fun stopBattle()
}