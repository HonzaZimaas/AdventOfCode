package main.r21.day5

import main.r21.day5e.Point

class GridOfPoints(private val size: Int) {
    private val grid = hashSetOf<Point>()

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

    fun getGlobalOverlay(overlaySize: Int): Int {
        return grid.count { it.overide >= overlaySize }
    }

    fun updatePointsX(x: Int, y1: Int, y2: Int) {
        val filteredGrid = grid.filter { it.x == x }
        filteredGrid.forEach { point ->
            if (point.y in y1..y2)
                point.addOverrlay()
        }
    }

    fun updatePointsY(y: Int, x1: Int, x2: Int) {
        val filteredGrid = grid.filter { it.y == y }
        filteredGrid.forEach { point ->
            if (point.x in x1..x2)
                point.addOverrlay()
        }
    }

    fun updateDiagonal(x: Int, y: Int, x2: Int, y2: Int) {
        val fillteredGrid = grid.filter { kotlin.math.abs(it.x - x) == kotlin.math.abs(it.y - y) }
        fillteredGrid.forEachIndexed { index, point ->
            if (x < x2) {

                if (point.x in x..x2 && point.y in y..y2) {
                    point.addOverrlay()
                }

                if (point.x in x..x2 && point.y in y2..y) {
                    point.addOverrlay()
                }
            } else {
                if (point.x in x2..x && point.y in y..y2) {
                    point.addOverrlay()
                }

                if (point.x in x2..x && point.y in y2..y) {
                    point.addOverrlay()
                }

            }
        }
    }
}