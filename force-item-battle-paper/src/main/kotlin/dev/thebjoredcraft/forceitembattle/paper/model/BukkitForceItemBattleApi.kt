package dev.thebjoredcraft.forceitembattle.paper.model

import dev.thebjoredcraft.forceitembattle.api.ForceItemBattleApi
import dev.thebjoredcraft.forceitembattle.api.model.Battle
import dev.thebjoredcraft.forceitembattle.api.model.BattleConfiguration

class BukkitForceItemBattleApi(): ForceItemBattleApi {
    private var running = false

    override fun isRunning(): Boolean {
        return running
    }

    override fun getBattle(): Battle? {
        TODO("Not yet implemented")
    }

    override suspend fun startBattle(config: BattleConfiguration) {
        TODO("Not yet implemented")
    }

    override suspend fun pauseBattle() {
        TODO("Not yet implemented")
    }

    override suspend fun resumeBattle() {
        TODO("Not yet implemented")
    }

    override suspend fun stopBattle() {
        TODO("Not yet implemented")
    }
}