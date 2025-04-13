package dev.thebjoredcraft.forceitembattle.api

import dev.thebjoredcraft.forceitembattle.api.model.Battle
import dev.thebjoredcraft.forceitembattle.api.model.BattleConfiguration
import net.kyori.adventure.util.Services

interface ForceItemBattleApi {
    fun isRunning(): Boolean
    fun getBattle(): Battle?

    suspend fun startBattle(config: BattleConfiguration)
    suspend fun pauseBattle()
    suspend fun resumeBattle()
    suspend fun stopBattle()

    companion object {
        val INSTANCE: ForceItemBattleApi = Services.serviceWithFallback(ForceItemBattleApi::class.java).orElseThrow { IllegalStateException("There is no fallback service for ${this::class.java.name} available.") }
    }
}

val forceItemBattleApi get() = ForceItemBattleApi.INSTANCE