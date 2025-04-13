package dev.thebjoredcraft.forceitembattle.core

import dev.thebjoredcraft.forceitembattle.api.model.BattleTeam
import it.unimi.dsi.fastutil.objects.ObjectSet
import net.kyori.adventure.util.Services
import java.util.UUID

interface TeamManager {
    suspend fun getTeam(uuid: UUID): BattleTeam?
    suspend fun getTeams(): ObjectSet<BattleTeam>

    suspend fun joinTeam(uuid: UUID, team: BattleTeam)
    suspend fun leaveTeam(uuid: UUID, team: BattleTeam)
    fun editTeam(team: BattleTeam, edit: (BattleTeam) -> Unit): BattleTeam

    suspend fun loadTeams()
    suspend fun saveTeams()

    companion object {
        val INSTANCE: TeamManager = Services.serviceWithFallback(TeamManager::class.java).orElseThrow { IllegalStateException("There is no fallback service for ${this::class.java.name} available.") }
    }
}

val teamManager get() = TeamManager.INSTANCE