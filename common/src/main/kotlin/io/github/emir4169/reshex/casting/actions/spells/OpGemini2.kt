package io.github.emir4169.reshex.casting.actions.spells

import at.petrak.hexcasting.api.casting.castables.ConstMediaAction
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment
import at.petrak.hexcasting.api.casting.getPositiveInt
import at.petrak.hexcasting.api.casting.iota.Iota
import at.petrak.hexcasting.api.casting.iota.ListIota
import at.petrak.hexcasting.common.lib.hex.HexIotaTypes

object OpGemini2: ConstMediaAction {
        override val argc: Int
            get() = 2

        override fun execute(args: List<Iota>, env: CastingEnvironment): List<Iota> {
            var count = args.getPositiveInt(1, argc)

            if (count > HexIotaTypes.MAX_SERIALIZATION_TOTAL) {
                count = HexIotaTypes.MAX_SERIALIZATION_TOTAL
            }
            return (List(0){ List(count) { args[0] } as ListIota})
        }
}