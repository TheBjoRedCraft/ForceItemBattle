package dev.thebjoredcraft.forceitembattle.api

import dev.thebjoredcraft.forceitembattle.api.type.BattleState

interface ForceItemBattleApi {
    fun getState(): BattleState
}