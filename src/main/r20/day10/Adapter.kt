package main.r20.day10

class Adapter(private val lines: List<Int>) {
    private val initialNumber = 0
    private var joltDiff = 0
    private var joltsDiff = 1 // last one

    fun scanAdaptersChain() {
        var currentAdapter = initialNumber

        while (currentAdapter != -1) {
            currentAdapter = findNextAdapter(currentAdapter)
        }

        println("1-jolt: $joltDiff")
        println("3-jolt: $joltsDiff")
        println("--------------")
        println(joltDiff * joltsDiff)
        println("--------------")
    }

    private fun findNextAdapter(current: Int): Int {
        when {
            nextAdapterExist(current + 1) -> {
                joltDiff += 1
                return current + 1
            }
            nextAdapterExist(current + 2) -> return current + 2
            nextAdapterExist(current + 3) -> {
                joltsDiff += 1
                return current + 3
            }
        }
        return -1
    }

    private fun nextAdapterExist(number: Int): Boolean {
        return lines.find { it == number } != null
    }
}