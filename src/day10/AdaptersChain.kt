package day10

fun main() {
    val lines = loadInputData()

    val adapters = Adapter(lines)
    adapters.scanAdaptersChain()

    val adaptersVarious = AdaptersCombinations(lines)
    adaptersVarious.findAllCombinations()
}

fun loadInputData(): List<Int> {
    val string = {}.javaClass.getResourceAsStream("/day10_input.txt").bufferedReader().readText().split("\n")
    return string.map { it.toInt() }
}
