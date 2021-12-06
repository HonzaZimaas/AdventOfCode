package main.r21.day5

fun main() {
    val lines: List<String> =
        {}.javaClass.getResourceAsStream("/r21/day5/test-input.txt")!!.bufferedReader().readLines()

    val linePoints = lines.map(::LinePoints)

    val filteredLines = linePoints.filter { it.resolveDirection() }
    println("---")
    filteredLines.forEach {
        println(it)
    }
}