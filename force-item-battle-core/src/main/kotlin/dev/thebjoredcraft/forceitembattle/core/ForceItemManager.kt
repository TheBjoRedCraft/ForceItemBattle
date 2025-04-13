package dev.thebjoredcraft.forceitembattle.core

import java.util.UUID

interface ForceItemManager {
    fun getCurrentItem(uuid: UUID)
    fun getNewItem(uuid: UUID)
}