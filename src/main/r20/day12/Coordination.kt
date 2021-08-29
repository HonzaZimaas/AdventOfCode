package main.r20.day12

data class Coordination(private val directLeter: String, val distance: Int) {
    val direct = getDirectType(directLeter)
    val rotationDegree = getRotationDegree(distance)

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
        throw IllegalStateException("This will never happend: $direct")
    }

    private fun getRotationDegree(distance: Int): Int? {
        return if (direct == DirectType.LEFT || direct == DirectType.RIGHT) distance / 90 else null
    }

    enum class DirectType {
        EAST, SOUTH, WEST, NORTH, LEFT, RIGHT, FORWARD
    }
}