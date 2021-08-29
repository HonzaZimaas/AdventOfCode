package main.r20.day10

class AdaptersCombinations(private val adapters: List<Int>) {
    private var alreadyChainedAdapters = mutableMapOf<Int, Long>()
    private val notChainedAdapters = mutableListOf(0)
    private var combinations = 0L

    fun findAllCombinations() {
        alreadyChainedAdapters[adapters.maxOf { it }] = 1L

        while (notChainedAdapters.isNotEmpty()) {
            val currentAdapter = findTheBestCandidate(notChainedAdapters)
            notChainedAdapters.remove(currentAdapter)

            if (alreadyChainedAdapters.containsKey(currentAdapter)) {
                combinations += alreadyChainedAdapters[currentAdapter]!!

            } else {
                val otherChainChoices = findNextChainChoices(currentAdapter)

                allChoicesIsCounted(currentAdapter, otherChainChoices, alreadyChainedAdapters)
                notChainedAdapters.addAll(otherChainChoices)
            }

            println("$currentAdapter: $notChainedAdapters")
            println("Current combinations: $combinations")
            println("-----")
        }
    }

    private fun allChoicesIsCounted(current: Int, choices: List<Int>, map: Map<Int, Long>) {
        if (choices.all { map.containsKey(it) }) {
            var combinations = 0L
            choices.forEach { choice ->
                combinations += map[choice]!!
            }
            alreadyChainedAdapters[current] = combinations
        }
    }

    private fun findTheBestCandidate(list: List<Int>): Int {
        return list.last()
    }

    private fun findNextChainChoices(adapter: Int): List<Int> {
        val active = mutableListOf<Int>()

        for (a in 1..3) {
            if (nextAdapterExist(adapter + a) != null) {
                active.add(adapter + a)
            }
        }

        return active
    }

    private fun nextAdapterExist(number: Int): Int? {
        return adapters.find { it == number }
    }
}