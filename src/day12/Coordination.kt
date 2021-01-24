package day12

import java.lang.IllegalStateException

data class Coordination(private val directLeter: String, val distance: Int) {
    val direct = getDirectType(directLeter)

    private fun getDirectType(direct: String): DirectType {
        when (direct) {
            "N" -> return DirectType.NORTH
            "E" -> return DirectType.EAST
            "S" -> return DirectType.SOUTH
            "W" -> return DirectType.WEST
            "L" -> return DirectType.LEFT
            "R" -> return DirectType.RIGHT
            "F" -> return DirectType.FORWARD
        }
        throw IllegalStateException("This could never happend $direct    ")
    }

    enum class DirectType {
        EAST, SOUTH, WEST, NORTH, LEFT, RIGHT, FORWARD
    }
}