package main.r21.day5

class LinePoints(line: String, private var gridOfPoints: GridOfPoints) {
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

    fun calculateDirection() {
        if (horizontal) {
            val diffNumber = kotlin.math.abs(basePoint.x - directPoint.x)
            for (diff in 0 until diffNumber) {
                gridOfPoints.getPointFromGrid(diff, basePoint.y).setOveride()
            }
        }
        if (vertical) {
            val diffNumber = kotlin.math.abs(basePoint.y - directPoint.y)
            for (diff in 0 until diffNumber) {
                gridOfPoints.getPointFromGrid(basePoint.x, diff).setOveride()
            }
        }
    }

    private fun parsePoints(line: String) {
        val points = line.split(" -> ")
        basePoint = getPoints(points.first())
        directPoint = getPoints(points.last())
    }

    private fun getPoints(point: String): Point {
        val splitted = point.split(",").map { it.toInt() }
        return gridOfPoints.getPointFromGrid(splitted[0], splitted[1])
    }

    private fun isHorintal(): Boolean {
        return basePoint.y == directPoint.y
    }

    private fun isVertical(): Boolean {
        return basePoint.x == directPoint.x
    }

    override fun toString(): String {
        return "Point $basePoint, $directPoint, ${resolveDirection()}"
    }
}