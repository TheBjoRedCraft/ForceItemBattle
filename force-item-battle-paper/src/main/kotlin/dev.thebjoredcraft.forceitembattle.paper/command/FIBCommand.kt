package dev.thebjoredcraft.forceitembattle.paper.command

import dev.jorel.commandapi.CommandAPICommand
import dev.jorel.commandapi.kotlindsl.subcommand

class FIBCommand(commandName: String): CommandAPICommand(commandName) {
    init {
        withPermission("forceitembattle.command.forceitembattle")

        subcommand(FIBSkipCommand("skip"))
    }
}