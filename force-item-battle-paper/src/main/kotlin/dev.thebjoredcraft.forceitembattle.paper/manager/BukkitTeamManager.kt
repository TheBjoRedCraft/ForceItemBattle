package dev.thebjoredcraft.forceitembattle.paper.manager

import com.google.auto.service.AutoService
import dev.thebjoredcraft.forceitembattle.api.model.BattleTeam
import dev.thebjoredcraft.forceitembattle.core.TeamManager
import it.unimi.dsi.fastutil.objects.ObjectArraySet
import it.unimi.dsi.fastutil.objects.ObjectSet
import net.kyori.adventure.util.Services.Fallback
import java.util.*

@AutoService(TeamManager::class)
class BukkitTeamManager(): TeamManager, Fallback {
    val teams: ObjectSet<BattleTeam> = ObjectArraySet()

    override suspend fun getTeam(uuid: UUID) {
        teams.filter { it.players.contains() }
    }

    override suspend fun getTeams(): ObjectSet<BattleTeam> {
        TODO("Not yet implemented")
    }

    override suspend fun joinTeam(uuid: UUID, team: BattleTeam) {
        TODO("Not yet implemented")
    }

    override suspend fun leaveTeam(uuid: UUID, team: BattleTeam) {
        TODO("Not yet implemented")
    }

    override suspend fun editTeam(team: BattleTeam, edit: (BattleTeam) -> Unit): BattleTeam {
        TODO("Not yet implemented")
    }

    override suspend fun loadTeams() {
        TODO("Not yet implemented")
    }

    override suspend fun saveTeams() {
        TODO("Not yet implemented")
    }
}