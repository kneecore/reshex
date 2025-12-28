package io.github.emir4169.reshex

import dev.architectury.platform.Platform
import io.github.emir4169.reshex.config.ReshexServerConfig
import io.github.emir4169.reshex.networking.ReshexNetworking
import io.github.emir4169.reshex.registry.ReshexActions
import net.minecraft.resources.ResourceLocation
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

object Reshex {
    const val MODID = "reshex"
    var HEXAL_INTEROP: Boolean = false
    fun isModLoaded(modid: String?): Boolean {
        return Platform.isModLoaded(modid)
    }
    @JvmField
    val LOGGER: Logger = LogManager.getLogger(MODID)

    @JvmStatic
    fun id(path: String) = ResourceLocation(MODID, path)

    fun init() {
        ReshexServerConfig.init()
        initRegistries(
            ReshexActions,
        )
        ReshexNetworking.init()
    }

    fun initServer() {
        ReshexServerConfig.initServer()
    }
}
