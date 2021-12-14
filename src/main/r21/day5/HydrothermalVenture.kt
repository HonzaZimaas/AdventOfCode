package main.r21.day5

fun main() {
    val lines: List<String> =
        {}.javaClass.getResourceAsStream("/r21/day5/input.txt")!!.bufferedReader().readLines()

    val gridOfPoints = GridOfPoints(999)
    val linePoints = lines.map(::LinePoints)
    val filteredLines = linePoints.filter { it.resolveDirection() }
    filteredLines.forEach { println(it) }

    OverlayCalculator(filteredLines, gridOfPoints).calculateDirection()

    println("---")
    println("Count of point with overlay at least size 2: ${gridOfPoints.getGlobalOverlay(2)}")
}