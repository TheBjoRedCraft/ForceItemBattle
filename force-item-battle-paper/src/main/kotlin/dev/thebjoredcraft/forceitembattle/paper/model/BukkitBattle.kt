package dev.thebjoredcraft.forceitembattle.paper.model

import dev.thebjoredcraft.forceitembattle.api.model.Battle
import dev.thebjoredcraft.forceitembattle.api.model.BattleConfiguration
import dev.thebjoredcraft.forceitembattle.api.model.BattlePlayer
import dev.thebjoredcraft.forceitembattle.api.type.BattleState
import it.unimi.dsi.fastutil.objects.ObjectArraySet
import it.unimi.dsi.fastutil.objects.ObjectSet

class BukkitBattle (
    override val configuration: BattleConfiguration,
    override var state: BattleState = BattleState.UNDEFINED,
    override val players: ObjectSet<BattlePlayer> = ObjectArraySet()
): Battle {

}