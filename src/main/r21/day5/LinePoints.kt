package main.r21.day5

class LinePoints(private var line: String) {
    val pointsMap: MutableMap<String, MutableMap<String, Int>>
        get() = parsePoints(line)

    val horizontal
        get() = isHorintal()

    val vertical
        get() = isVertical()

    val diagonal
        get() = isDiagonal()

    fun resolveDirection(): Boolean {
        return horizontal || vertical || diagonal
    }

    private fun parsePoints(line: String): MutableMap<String, MutableMap<String, Int>> {
        val points = line.split(" -> ")
        return mutableMapOf("base" to getPoints(points.first()), "direct" to getPoints(points.last()))
    }

    private fun getPoints(point: String): MutableMap<String, Int> {
        val splitted = point.split(",").map { it.toInt() }
        return mutableMapOf("x" to splitted[0], "y" to splitted[1])
    }

    private fun isHorintal(): Boolean {
        return pointsMap["base"]!!["y"] == pointsMap["direct"]!!["y"]
    }

    private fun isVertical(): Boolean {
        return pointsMap["base"]!!["x"] == pointsMap["direct"]!!["x"]
    }

    private fun isDiagonal(): Boolean {
        return mathDiagonal(pointsMap["base"]!!, pointsMap["direct"]!!)
    }

    private fun mathDiagonal(map1: MutableMap<String, Int>, map2: MutableMap<String, Int>): Boolean {
        return kotlin.math.abs(map1["x"]!! - map2["x"]!!) == kotlin.math.abs(map1["y"]!! - map2["y"]!!)
    }

    override fun toString(): String {
        return "${pointsMap["base"]!!["x"]}, ${pointsMap["base"]!!["y"]}, -> ${pointsMap["direct"]!!["x"]}, ${pointsMap["direct"]!!["y"]}  $horizontal, $vertical, $diagonal"
    }
}