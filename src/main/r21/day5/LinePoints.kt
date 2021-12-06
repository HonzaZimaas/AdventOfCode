package main.r21.day5

class LinePoints(line: String) {
    private var horizontal = false
    private var vertical = false
    private lateinit var basePoint: Point
    private lateinit var directPoint: Point

    init {
        parsePoints(line)
    }

    fun resolveDirection(): Boolean {
        horizontal = isHorintal()
        vertical = isVertical()
        return horizontal || vertical
    }

    private fun parsePoints(line: String) {
        val points = line.split(" -> ")
        basePoint = getPoints(points.first())
        directPoint = getPoints(points.last())
    }

    private fun getPoints(point: String): Point {
        val splitted = point.split(",").map { it.toInt() }
        return Point(splitted[0], splitted[1])
    }

    private fun isHorintal(): Boolean {
        return basePoint.x == directPoint.x
    }

    private fun isVertical(): Boolean {
        return basePoint.y == directPoint.y
    }

    override fun toString(): String {
        return "Point $basePoint, $directPoint, ${resolveDirection()}"
    }
}