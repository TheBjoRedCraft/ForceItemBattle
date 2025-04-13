package dev.thebjoredcraft.forceitembattle.paper.model

import dev.thebjoredcraft.forceitembattle.api.model.Battle
import dev.thebjoredcraft.forceitembattle.api.model.BattleConfiguration
import dev.thebjoredcraft.forceitembattle.api.model.BattlePlayer
import dev.thebjoredcraft.forceitembattle.api.type.BattleState
import it.unimi.dsi.fastutil.objects.ObjectSet

class BukkitBattle(
    override val configuration: BattleConfiguration,
    override val state: BattleState,
    override val players: ObjectSet<BattlePlayer>
): Battle {

}