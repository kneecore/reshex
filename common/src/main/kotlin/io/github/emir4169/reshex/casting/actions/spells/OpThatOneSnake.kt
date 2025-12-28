package io.github.emir4169.reshex.casting.actions.spells
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment
import at.petrak.hexcasting.api.casting.iota.Iota
import at.petrak.hexcasting.api.casting.asActionResult
import at.petrak.hexcasting.api.casting.castables.ConstMediaAction
import at.petrak.hexcasting.api.casting.math.HexDir
import at.petrak.hexcasting.api.casting.math.HexPattern

// he who ouroborus
object OpThatOneSnake : ConstMediaAction {
    override val argc = 0
    override fun execute(args: List<Iota>, env: CastingEnvironment): List<Iota> {
        return HexPattern.fromAngles("dwewdeaqqwqqwwqwwqqwa",HexDir.SOUTH_EAST).asActionResult;
    }
}
