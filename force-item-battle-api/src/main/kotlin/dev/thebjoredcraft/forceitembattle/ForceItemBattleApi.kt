package dev.thebjoredcraft.forceitembattle

import dev.thebjoredcraft.forceitembattle.type.BattleState

interface ForceItemBattleApi {
    fun getState(): BattleState
}