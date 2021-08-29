package main.r20.day9

fun main() {
    val numbers = Numbers(loadInputData())
    numbers.count()
}

fun loadInputData(): List<Long> {
    val string = {}.javaClass.getResourceAsStream("/r20/day9_input.txt")!!.bufferedReader().readText().split("\n")
    return string.map { it.toLong() }
}
