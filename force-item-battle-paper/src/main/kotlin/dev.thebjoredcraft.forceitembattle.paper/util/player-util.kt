package dev.thebjoredcraft.forceitembattle.paper.util

import dev.thebjoredcraft.forceitembattle.api.model.BattlePlayer
import dev.thebjoredcraft.forceitembattle.core.playerManager
import org.bukkit.Bukkit
import org.bukkit.entity.Player

fun Player.toBattlePlayer(): BattlePlayer {
    return playerManager.getPlayer(this.uniqueId)
}

fun BattlePlayer.toPlayer(): Player? {
    return Bukkit.getPlayer(this.uuid)
}

fun BattlePlayer.edit(block: BattlePlayer.() -> Unit): BattlePlayer {
    return playerManager.editPlayer(this, block)
}