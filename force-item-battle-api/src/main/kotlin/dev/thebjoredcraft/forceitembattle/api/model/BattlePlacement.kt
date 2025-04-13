package dev.thebjoredcraft.forceitembattle.api.model

import it.unimi.dsi.fastutil.objects.ObjectList

interface BattlePlacement {
    val placement: Int
    val succeededTasks: ObjectList<BattleTask>
}