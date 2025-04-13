package dev.thebjoredcraft.forceitembattle.api.model

import it.unimi.dsi.fastutil.objects.ObjectList

interface BattleTeam {
    var size: Int
    val players: ObjectList<BattlePlayer>
    var skipsRemaining: Int
}