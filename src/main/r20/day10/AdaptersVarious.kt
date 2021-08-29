package main.r20.day10

// Skončí s Java Heap
class AdaptersVarious(private val adapters: List<Int>) {
    private val initialNumberList = listOf(0)
    private var count = 0

    fun findAllVarious() {
        var currentAdapter = initialNumberList

        while (currentAdapter.isNotEmpty()) {
            currentAdapter = findNextChainChoices(currentAdapter)
            count += currentAdapter.filter { it -> it == adapters.maxOf { it } }.size
        }
        println("-----")
        println("Count: ${count}")
    }

    private fun findNextChainChoices(input: List<Int>): List<Int> {
        val list = mutableListOf<Int>()

        input.forEach {
            list.addAll(hasChain(it))
        }
        return list
    }


    private fun hasChain(adapter: Int): List<Int> {
        val listOfNext = mutableListOf<Int>()

        if (nextAdapterExist(adapter + 1)) {
            listOfNext.add(adapter + 1)
        }

        if (nextAdapterExist(adapter + 2)) {
            listOfNext.add(adapter + 2)
        }

        if (nextAdapterExist(adapter + 3)) {
            listOfNext.add(adapter + 3)
        }
        return listOfNext
    }

    private fun nextAdapterExist(number: Int): Boolean {
        return adapters.find { it == number } != null
    }
}