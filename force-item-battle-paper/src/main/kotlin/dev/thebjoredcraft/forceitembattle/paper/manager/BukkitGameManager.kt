package dev.thebjoredcraft.forceitembattle.paper.manager

import com.google.auto.service.AutoService
import dev.thebjoredcraft.forceitembattle.api.model.Battle
import dev.thebjoredcraft.forceitembattle.api.type.BattleDifficulty
import dev.thebjoredcraft.forceitembattle.api.type.BattleState
import dev.thebjoredcraft.forceitembattle.core.GameManager
import dev.thebjoredcraft.forceitembattle.paper.model.BukkitBattle
import dev.thebjoredcraft.forceitembattle.paper.model.BukkitBattleConfiguration
import dev.thebjoredcraft.forceitembattle.paper.plugin
import dev.thebjoredcraft.forceitembattle.paper.util.MessageBuilder
import dev.thebjoredcraft.forceitembattle.paper.util.sendActionbar
import dev.thebjoredcraft.forceitembattle.paper.util.sendText
import dev.thebjoredcraft.forceitembattle.paper.util.toPlayer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import net.kyori.adventure.util.Services.Fallback
import org.bukkit.scheduler.BukkitRunnable

@AutoService(GameManager::class)
class BukkitGameManager(): GameManager, Fallback {
    private var battle: Battle? = null
    private var runnable: BukkitRunnable? = null

    override suspend fun start() = withContext(Dispatchers.IO) {
        battle = BukkitBattle(BukkitBattleConfiguration (
            plugin.config.getInt("battle.teams.minSize"),
            plugin.config.getInt("battle.teams.maxSize"),
            plugin.config.getLong("battle.game.duration"),
            BattleDifficulty.valueOf(plugin.config.getString("battle.game.difficulity") ?: "EASY"),
            plugin.config.getInt("battle.game.skipCount"),
        ))

        val runningBattle = battle ?: return@withContext

        runnable = object: BukkitRunnable() {
            override fun run() {
                runningBattle.players.forEach {
                    when(runningBattle.state) {
                        BattleState.LOBBY -> {
                            it.sendActionbar (
                                MessageBuilder()
                            )
                        }
                        BattleState.STARTING -> TODO()
                        BattleState.RUNNING -> TODO()
                        BattleState.PAUSED -> TODO()
                        BattleState.EVALUATION -> TODO()
                        BattleState.ENDING -> TODO()

                        else -> {
                            /**
                             * Do nothing
                             */
                        }
                    }
                }
            }
        }
        runnable?.runTaskTimerAsynchronously(plugin, 0L, 50L) ?: return@withContext
    }

    override suspend fun pause() {
        val battle = battle ?: return

        battle.state = BattleState.PAUSED
    }

    override suspend fun resume() {
        val battle = battle ?: return

        battle.state = BattleState.RUNNING
    }

    override suspend fun stop() {
        val battle = battle ?: return

        battle.state = BattleState.ENDING
    }

    override suspend fun isRunning(): Boolean {
        return battle?.state == BattleState.RUNNING
    }

    override suspend fun isPaused(): Boolean {
        return battle?.state == BattleState.PAUSED
    }

    override suspend fun getBattle(): Battle? {
        return battle
    }
}