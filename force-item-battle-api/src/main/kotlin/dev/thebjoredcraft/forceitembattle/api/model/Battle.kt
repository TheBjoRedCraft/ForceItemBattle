package dev.thebjoredcraft.forceitembattle.api.model

import dev.thebjoredcraft.forceitembattle.api.type.BattleState
import it.unimi.dsi.fastutil.objects.ObjectSet

interface Battle {
    val configuration: BattleConfiguration
    val state: BattleState

    val players: ObjectSet<BattlePlayer>
}