package main.r21.day5

fun main() {
    val lines: List<String> =
        {}.javaClass.getResourceAsStream("/r21/day5/test-input.txt")!!.bufferedReader().readLines()

    val gridOfPoints = GridOfPoints(10)
    val linePoints = mutableListOf<LinePoints>()
    lines.forEach { line ->
        linePoints.add(LinePoints(line, gridOfPoints))
    }

    val filteredLines = linePoints.filter { it.resolveDirection() }
    filteredLines.forEach { it.calculateDirection() }
    println("Count of point with overlay size 2: ${gridOfPoints.getGlobalOverlay(2)}")
}