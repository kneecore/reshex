package io.github.emir4169.reshex.registry

import at.petrak.hexcasting.api.casting.ActionRegistryEntry
import at.petrak.hexcasting.api.casting.castables.Action
import at.petrak.hexcasting.api.casting.math.HexDir
import at.petrak.hexcasting.api.casting.math.HexPattern
import at.petrak.hexcasting.common.lib.HexRegistries
import at.petrak.hexcasting.common.lib.hex.HexActions
import dev.architectury.platform.Platform
import io.github.emir4169.reshex.casting.actions.spells.*

object ReshexActions : ReshexRegistrar<ActionRegistryEntry>(
    HexRegistries.ACTION,
    { HexActions.REGISTRY },
) {
    val THOTH_COUSIN = make("thoths_cousin", HexDir.SOUTH_EAST, "adadaqadada", OpThothsCousin)
    val THATONESNAKE = make("thatonesnake", HexDir.SOUTH_EAST, "dwewdeaqqwqqwwqwwqqwa", OpThatOneSnake)
    //val interopthingy = make("stocktakersrefl2", HexDir.SOUTH_EAST, "eewaqaweedww", OpHexal_StocktakersRefl, "hexal")
    val GIVEGARBAGE = make("garbage_refl", HexDir.SOUTH_EAST, "awaawawqaqwedadadewwd", OpGiveGarbage)
    val EATGARBAGE = make("garbage_purification", HexDir.SOUTH_EAST, "eeeaqqwqwqq", OpEatGarbage)
    fun make(name: String, startDir: HexDir, signature: String, action: Action, interopID: String) {
        if (Platform.isModLoaded(interopID)) {
            make(name, startDir, signature) { action }
        }
    }
    fun make(name: String, startDir: HexDir, signature: String, action: Action) =
        make(name, startDir, signature) { action }

    fun make(name: String, startDir: HexDir, signature: String, getAction: () -> Action) = register(name) {
        ActionRegistryEntry(HexPattern.fromAngles(signature, startDir), getAction())
    }
}
