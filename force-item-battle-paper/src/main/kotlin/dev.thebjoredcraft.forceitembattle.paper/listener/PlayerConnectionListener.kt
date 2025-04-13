package dev.thebjoredcraft.forceitembattle.paper.listener

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class PlayerConnectionListener(): Listener {
    @EventHandler
    fun onConnect(event: PlayerJoinEvent) {
        val player = event.player
    }

    @EventHandler
    fun onDisconnect(event: PlayerQuitEvent) {
        val player = event.player
    }
}