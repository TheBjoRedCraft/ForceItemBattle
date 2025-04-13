package dev.thebjoredcraft.forceitembattle.paper.command

import com.github.shynixn.mccoroutine.folia.launch
import dev.jorel.commandapi.CommandAPICommand
import dev.jorel.commandapi.kotlindsl.playerExecutor
import dev.thebjoredcraft.forceitembattle.core.teamManager
import dev.thebjoredcraft.forceitembattle.paper.plugin
import dev.thebjoredcraft.forceitembattle.paper.util.MessageBuilder
import dev.thebjoredcraft.forceitembattle.paper.util.sendText

class FIBSkipCommand(commandName: String): CommandAPICommand(commandName) {
    init {
        withPermission("forceitembattle.command.skip")

        playerExecutor { player, _ ->
            plugin.launch {
                val team = teamManager.getTeam(player.uniqueId) ?: return@launch player.sendText(
                    MessageBuilder().error("Du bist in keinem Team.")
                )

                if(team.skipsRemaining < 1) {
                    player.sendText(MessageBuilder().error("Du hast nicht genug Skips übrig."))
                    return@launch
                }

                team.update {
                    skipsRemaining--
                }
            }
        }
    }
}