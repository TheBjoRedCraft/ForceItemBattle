package dev.thebjoredcraft.forceitembattle.paper

import com.github.shynixn.mccoroutine.folia.SuspendingJavaPlugin
import com.google.gson.Gson
import org.bukkit.plugin.java.JavaPlugin

class ForceItemBattleBukkit(): SuspendingJavaPlugin() {

}

val plugin get() = JavaPlugin.getPlugin(ForceItemBattleBukkit::class.java)
val gson get() = Gson()