package dev.thebjoredcraft.forceitembattle.api.model

import dev.thebjoredcraft.forceitembattle.api.type.BattleRole
import java.util.UUID

interface BattlePlayer {
    val uuid: UUID

    var role: BattleRole
}