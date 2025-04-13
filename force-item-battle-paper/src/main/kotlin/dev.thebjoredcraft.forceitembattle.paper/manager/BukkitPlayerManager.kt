package dev.thebjoredcraft.forceitembattle.paper.manager

import com.google.auto.service.AutoService
import dev.thebjoredcraft.forceitembattle.api.model.BattlePlayer
import dev.thebjoredcraft.forceitembattle.core.PlayerManager
import dev.thebjoredcraft.forceitembattle.paper.model.BukkitBattlePlayer
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap
import net.kyori.adventure.util.Services.Fallback
import java.util.*

@AutoService(PlayerManager::class)
class BukkitPlayerManager(): PlayerManager, Fallback {
    private val playerList = Object2ObjectOpenHashMap<UUID, BattlePlayer>()

    override fun getPlayer(uuid: UUID): BattlePlayer {
        return playerList[uuid] ?: BukkitBattlePlayer(uuid)
    }

    fun editPlayer(player: BattlePlayer, block: (BattlePlayer) -> Unit) {
        block(player)
        playerList[player.uuid] = player
    }
}