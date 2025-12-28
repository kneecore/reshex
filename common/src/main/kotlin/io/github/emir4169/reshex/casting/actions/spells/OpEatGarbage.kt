package io.github.emir4169.reshex.casting.actions.spells
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment
import at.petrak.hexcasting.api.casting.iota.Iota
import at.petrak.hexcasting.api.casting.asActionResult
import at.petrak.hexcasting.api.casting.castables.ConstMediaAction
import at.petrak.hexcasting.api.casting.getNumOrVec
import at.petrak.hexcasting.api.casting.iota.GarbageIota
import at.petrak.hexcasting.api.casting.math.HexDir
import at.petrak.hexcasting.api.casting.math.HexPattern
import at.petrak.hexcasting.api.casting.mishaps.MishapInvalidIota
import net.minecraft.network.chat.Component

// I LOVE EATING TRASH /ref
object OpEatGarbage : ConstMediaAction {
    override val argc: Int
        get() = 1

    override fun execute(args: List<Iota>, env: CastingEnvironment): List<Iota> {
        val lhs = args[0]
        if (GarbageIota.typesMatch(GarbageIota(), lhs)){
            return env.world.random.nextDouble().asActionResult
        } else {
            throw MishapInvalidIota(lhs,0, Component.literal("Garbage"));
        }
    }
}
