package dev.thebjoredcraft.forceitembattle.paper.util

import dev.thebjoredcraft.forceitembattle.api.model.BattlePlayer
import dev.thebjoredcraft.forceitembattle.core.playerManager
import net.kyori.adventure.text.Component
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

fun Player.sendText(component: Component) {
    this.sendMessage(Colors.PREFIX.append(component))
}

fun Player.sendText(messageBuilder: MessageBuilder) {
    this.sendMessage(Colors.PREFIX.append(messageBuilder.build()))
}

fun BattlePlayer.sendText(component: Component) {
    this.toPlayer()?.sendText(component) ?: return
}

fun BattlePlayer.sendText(messageBuilder: MessageBuilder) {
    this.toPlayer()?.sendText(messageBuilder) ?: return
}

fun BattlePlayer.sendActionbar(messageBuilder: MessageBuilder) {
    val player = this.toPlayer() ?: return
    player.sendActionBar(messageBuilder.build())
}

fun Player.sendRawText(component: Component) {
    this.sendMessage(component)
}