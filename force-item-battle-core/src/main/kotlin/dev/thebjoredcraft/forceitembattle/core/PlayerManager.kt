package dev.thebjoredcraft.forceitembattle.core

import dev.thebjoredcraft.forceitembattle.api.model.BattlePlayer
import net.kyori.adventure.util.Services
import java.util.*

interface PlayerManager {
    fun getPlayer(uuid: UUID): BattlePlayer
    fun editPlayer(player: BattlePlayer, edit: (BattlePlayer) -> Unit): BattlePlayer

    companion object {
        val INSTANCE: PlayerManager = Services.serviceWithFallback(PlayerManager::class.java).orElseThrow { IllegalStateException("There is no fallback service for ${this::class.java.name} available.") }
    }
}

val playerManager get() = PlayerManager.INSTANCE