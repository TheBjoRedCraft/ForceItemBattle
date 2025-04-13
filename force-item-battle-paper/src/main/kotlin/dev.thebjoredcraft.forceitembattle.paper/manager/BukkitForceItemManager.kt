package dev.thebjoredcraft.forceitembattle.paper.manager

import com.google.auto.service.AutoService
import dev.thebjoredcraft.forceitembattle.api.type.BattleDifficulty
import dev.thebjoredcraft.forceitembattle.core.ForceItemManager
import dev.thebjoredcraft.forceitembattle.core.forceItemManager
import dev.thebjoredcraft.forceitembattle.core.gameManager
import dev.thebjoredcraft.forceitembattle.core.teamManager
import dev.thebjoredcraft.forceitembattle.paper.model.BukkitBattleTask
import dev.thebjoredcraft.forceitembattle.paper.model.BukkitBattleTeam
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap
import it.unimi.dsi.fastutil.objects.ObjectArraySet
import it.unimi.dsi.fastutil.objects.ObjectSet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import net.kyori.adventure.util.Services.Fallback
import org.bukkit.Material
import java.util.*

@AutoService(ForceItemManager::class)
class BukkitForceItemManager: ForceItemManager, Fallback {
    private val items: ObjectSet<Material> = ObjectArraySet()
    private val currentItems = Object2ObjectOpenHashMap<BukkitBattleTeam, BukkitBattleTask>()

    override suspend fun loadItems() {
        items.addAll(Material.entries.filter { it.isItem })
    }

    override suspend fun getCurrentItem(uuid: UUID): Material? {
        return currentItems[teamManager.getTeam(uuid) ?: return null]?.item
    }

    override suspend fun getNewItem(uuid: UUID): Material? = withContext(Dispatchers.IO) {
        val difficulty = gameManager.getBattle()?.configuration?.difficulty ?: return@withContext null

        return@withContext when(difficulty) {
            BattleDifficulty.EASY -> {
                forceItemManager.getOverworldItems().random()
            }

            BattleDifficulty.NORMAL -> {
                listOf(forceItemManager.getOverworldItems(), forceItemManager.getNetherItems()).random().random()
            }

            BattleDifficulty.HARD -> {
                listOf(forceItemManager.getOverworldItems(), forceItemManager.getNetherItems(), forceItemManager.getEndItems()).random().random()
            }

            BattleDifficulty.INSANE -> {
                listOf(forceItemManager.getNetherItems(), forceItemManager.getEndItems()).random().random()
            }
        }
    }

    override suspend fun markAsFinished(skipped: Boolean, completer: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getOverworldItems(): ObjectSet<Material> = withContext(Dispatchers.IO) {
        return@withContext ObjectArraySet<Material>().apply {
            addAll(listOf(
                // --- Blocks & Naturals ---
                Material.OAK_LOG, Material.SPRUCE_LOG, Material.BIRCH_LOG, Material.JUNGLE_LOG,
                Material.ACACIA_LOG, Material.DARK_OAK_LOG, Material.CHERRY_LOG, Material.MANGROVE_LOG, Material.BAMBOO_BLOCK,
                Material.STONE, Material.COBBLESTONE, Material.GRANITE, Material.DIORITE, Material.ANDESITE,
                Material.TUFF, Material.CALCITE, Material.DRIPSTONE_BLOCK,
                Material.COAL_ORE, Material.IRON_ORE, Material.COPPER_ORE, Material.GOLD_ORE,
                Material.REDSTONE_ORE, Material.LAPIS_ORE, Material.DIAMOND_ORE, Material.EMERALD_ORE,
                Material.SAND, Material.RED_SAND, Material.GRAVEL, Material.CLAY,
                Material.DIRT, Material.COARSE_DIRT, Material.ROOTED_DIRT, Material.PODZOL, Material.MYCELIUM, Material.GRASS_BLOCK,
                Material.MOSS_BLOCK, Material.MOSS_CARPET, Material.AZALEA, Material.FLOWERING_AZALEA,
                Material.SUNFLOWER, Material.LILY_PAD, Material.VINE,

                // --- Redstone & Mechanik ---
                Material.REDSTONE, Material.REDSTONE_TORCH, Material.LEVER, Material.PISTON, Material.STICKY_PISTON,
                Material.OBSERVER, Material.DROPPER, Material.DISPENSER, Material.HOPPER, Material.COMPARATOR, Material.REPEATER,
                Material.TRIPWIRE_HOOK, Material.NOTE_BLOCK, Material.DAYLIGHT_DETECTOR, Material.TARGET, Material.SCULK_SENSOR,

                // --- Werkzeuge & Waffen ---
                Material.WOODEN_SWORD, Material.WOODEN_AXE, Material.WOODEN_PICKAXE, Material.WOODEN_SHOVEL, Material.WOODEN_HOE,
                Material.STONE_SWORD, Material.STONE_AXE, Material.STONE_PICKAXE, Material.STONE_SHOVEL, Material.STONE_HOE,
                Material.IRON_SWORD, Material.IRON_AXE, Material.IRON_PICKAXE, Material.IRON_SHOVEL, Material.IRON_HOE,
                Material.GOLDEN_SWORD, Material.GOLDEN_AXE, Material.GOLDEN_PICKAXE, Material.GOLDEN_SHOVEL, Material.GOLDEN_HOE,
                Material.DIAMOND_SWORD, Material.DIAMOND_AXE, Material.DIAMOND_PICKAXE, Material.DIAMOND_SHOVEL, Material.DIAMOND_HOE,
                Material.BOW, Material.CROSSBOW, Material.TRIDENT,

                // --- Rüstung ---
                Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS,
                Material.IRON_HELMET, Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS, Material.IRON_BOOTS,
                Material.GOLDEN_HELMET, Material.GOLDEN_CHESTPLATE, Material.GOLDEN_LEGGINGS, Material.GOLDEN_BOOTS,
                Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS,

                // --- Sonstiges ---
                Material.PAPER, Material.BOOK, Material.MAP, Material.COMPASS,
                Material.STRING, Material.BONE, Material.SLIME_BALL, Material.ROTTEN_FLESH, Material.SPIDER_EYE,
                Material.FEATHER, Material.LEATHER, Material.FLINT, Material.INK_SAC, Material.GLOW_INK_SAC,
                Material.APPLE, Material.GOLDEN_APPLE, Material.ENCHANTED_GOLDEN_APPLE,
                Material.FISHING_ROD, Material.SHEARS, Material.BUCKET, Material.WATER_BUCKET, Material.MILK_BUCKET
            ))
        }
    }

    override suspend fun getNetherItems(): ObjectSet<Material> = withContext(Dispatchers.IO) {
        return@withContext ObjectArraySet<Material>().apply {
            addAll(listOf(
                Material.NETHERRACK, Material.BASALT, Material.SMOOTH_BASALT,
                Material.SOUL_SAND, Material.SOUL_SOIL,
                Material.BLACKSTONE, Material.GILDED_BLACKSTONE,
                Material.NETHER_QUARTZ_ORE, Material.NETHER_GOLD_ORE,
                Material.ANCIENT_DEBRIS, Material.NETHERITE_SCRAP,

                // Pflanzen etc.
                Material.CRIMSON_STEM, Material.WARPED_STEM, Material.CRIMSON_ROOTS, Material.WARPED_ROOTS,
                Material.CRIMSON_FUNGUS, Material.WARPED_FUNGUS, Material.NETHER_WART,
                Material.SHROOMLIGHT, Material.WEEPING_VINES, Material.TWISTING_VINES,

                // Drops & Loot
                Material.BLAZE_ROD, Material.MAGMA_CREAM, Material.GHAST_TEAR, Material.NETHER_STAR,
                Material.PIGLIN_HEAD, Material.WITHER_SKELETON_SKULL,
                Material.QUARTZ, Material.GOLD_NUGGET,

                // Redstone-Zeug
                Material.SOUL_TORCH, Material.SOUL_LANTERN, Material.LODESTONE,

                // Netherite Tools & Armor
                Material.NETHERITE_SWORD, Material.NETHERITE_AXE, Material.NETHERITE_PICKAXE, Material.NETHERITE_SHOVEL, Material.NETHERITE_HOE,
                Material.NETHERITE_HELMET, Material.NETHERITE_CHESTPLATE, Material.NETHERITE_LEGGINGS, Material.NETHERITE_BOOTS,
                Material.NETHERITE_INGOT
            ))
        }
    }

    override suspend fun getEndItems(): ObjectSet<Material> = withContext(Dispatchers.IO) {
        return@withContext ObjectArraySet<Material>().apply {
            addAll(listOf(
                Material.END_STONE, Material.OBSIDIAN,
                Material.CHORUS_FRUIT, Material.POPPED_CHORUS_FRUIT,
                Material.PURPUR_BLOCK, Material.PURPUR_PILLAR, Material.END_ROD,
                Material.ELYTRA, Material.SHULKER_SHELL, Material.DRAGON_BREATH, Material.DRAGON_EGG
            ))
        }
    }
}