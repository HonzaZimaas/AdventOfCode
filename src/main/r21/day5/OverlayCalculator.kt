package main.r21.day5

class OverlayCalculator(private val linePointsList: List<LinePoints>, private val gridOfPoints: GridOfPoints) {

    fun calculateDirection() {
        linePointsList.forEachIndexed { index, linePoint ->
            println("$index/${linePointsList.size}")
            val basePoint = linePoint.pointsMap["base"]!!
            val directPoint = linePoint.pointsMap["direct"]!!

            if (linePoint.horizontal) {
                if (basePoint["x"]!! < directPoint["x"]!!) {
                    gridOfPoints.updatePointsY(basePoint["y"]!!, basePoint["x"]!!, directPoint["x"]!!)
                } else {
                    gridOfPoints.updatePointsY(basePoint["y"]!!, directPoint["x"]!!, basePoint["x"]!!)
                }
            }
            if (linePoint.vertical) {
                if (basePoint["y"]!! < directPoint["y"]!!) {
                    gridOfPoints.updatePointsX(basePoint["x"]!!, basePoint["y"]!!, directPoint["y"]!!)
                } else {
                    gridOfPoints.updatePointsX(basePoint["x"]!!, directPoint["y"]!!, basePoint["y"]!!)
                }
            }
            if (linePoint.diagonal) {
                gridOfPoints.updateDiagonal(basePoint["x"]!!, basePoint["y"]!!, directPoint["x"]!!, directPoint["y"]!!)
            }
        }
    }
}