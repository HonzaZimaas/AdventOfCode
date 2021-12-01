package main.r21.day1

fun main() {
    val depthMeasurements: List<Int> =
        {}.javaClass.getResourceAsStream("/r21/day1/input.txt")!!.bufferedReader().readLines().map { it.toInt() }

    val sumOfIncreases = countIncreases(depthMeasurements)
    println(sumOfIncreases)

    val sumOfIncreasesGrupped = countIncreases(sumListByGroup(depthMeasurements))
    println(sumOfIncreasesGrupped)
}

fun sumListByGroup(depthMeasurements: List<Int>): List<Int> {
    return depthMeasurements.windowed(3, 1) { window -> window.sum() }
}

fun countIncreases(depthMeasurements: List<Int>): Int {
    var sumOfIncreases = 0
    depthMeasurements.forEachIndexed { index, depth ->
        try {
            if (depth < depthMeasurements[index + 1]) {
                sumOfIncreases += 1
            }
        } catch (e: IndexOutOfBoundsException) {
            println("Out of index, last element skipped!")
        }
    }
    return sumOfIncreases
}