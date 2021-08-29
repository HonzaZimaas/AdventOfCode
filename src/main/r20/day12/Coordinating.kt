package main.r20.day12

fun main() {
    val listOfCoordinations = loadInputData()

    val service = CoordinationService(listOfCoordinations)
    service.navigateAccordingToCoordination()
}


fun loadInputData(): List<Coordination> {
    val lines = {}.javaClass.getResourceAsStream("/r20/day12_input.txt")!!.bufferedReader().readText().split("\n")
    return lines.map { line ->
        Coordination(line.filter { it.isLetter() }, line.filter { it.isDigit() }.toInt())
    }
}