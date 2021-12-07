package main.r21.day5

class GridOfPoints(private val size: Int) {
    private val grid = mutableListOf<Point>()

    init {
        generateGrid()
    }

    private fun generateGrid() {
        for (i in 0 until size) {
            for (j in 0 until size) {
                grid.add(Point(i, j))
            }
        }
    }

    fun getPointFromGrid(x: Int, y: Int): Point {
        return grid.first { point -> point.x == x && point.y == y }
    }

    fun getGlobalOverlay(overlaySize: Int): Int {
        println(grid.filter { it.overide == overlaySize })
        return grid.count { it.overide == overlaySize }
    }
}