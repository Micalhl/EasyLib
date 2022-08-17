package me.mical.easylib.function

import org.bukkit.Location

/**
 * @author xiaomu
 * @since 2022/8/17 11:18
 */
fun String.parseLocation(): Location {
    val (world, loc) = split("~", limit = 2)
    val (x, y, z) = loc.split(",", limit = 3).map { it.toDouble() }

    return Location(plugin.server.getWorld(world), x, y, z)
}

fun Location.parseString(): String {
    val world = this.world!!.name
    val x = blockX
    val y = blockY
    val z = blockZ
    return "$world~$x,$y,$z"
}