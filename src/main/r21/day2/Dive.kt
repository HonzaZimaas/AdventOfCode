package main.r21.day2

fun main() {
    val commands: List<List<String>> =
        {}.javaClass.getResourceAsStream("/r21/day2/input.txt")!!.bufferedReader().readLines()
            .map { it.split(" ") }

    printResults(calculateDieDepth(commands, false))
    printResults(calculateDieDepth(commands, true))
}

private fun calculateDieDepth(mapOfCommands: List<List<String>>, withAim: Boolean): Map<String, Int> {
    var depth = 0
    var position = 0
    var aim = 0

    mapOfCommands.forEach { comand ->
        if (comand[0] == "forward") {
            position += comand[1].toInt()
            if (withAim) {
                depth += aim * comand[1].toInt()
            }
        }
        if (comand[0] == "down") {
            if (withAim) {
                aim += comand[1].toInt()
            } else {
                depth += comand[1].toInt()
            }
        }
        if (comand[0] == "up") {
            if (withAim) {
                aim -= comand[1].toInt()
            } else {
                depth -= comand[1].toInt()
            }
        }
    }
    return mapOf("possition" to position, "depth" to depth, "aim" to aim)
}

private fun printResults(results: Map<String, Int>) {
    println("Possition: ${results["possition"]}")
    println("Depth: ${results["depth"]}")
    val multiply = results["depth"]!!.times(results["possition"]!!)
    println("Multiply: $multiply")
}
