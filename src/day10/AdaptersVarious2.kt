package day10

// Plně funkční řešení, ale 3 mld generuje 8hodin
class AdaptersVarious2(private val adapters: List<Int>) {
    private var count = 0L

    fun findAllVarious() {
        val open = mutableListOf(0)

        while (open.isNotEmpty()) {
            val current = findCandidate(open)
            open.remove(current)
            open.addAll(findNextChainChoices(current))


            if (open.contains(adapters.maxOf { it })) {
                count += 1
                println("$current: $open")
                println(count)
                open.remove(current)
            }
        }

        println("-----")
        println("Count: $count")
    }

    private fun findCandidate(list: List<Int>): Int {
        return list.last()
    }


    private fun findNextChainChoices(adapter: Int): List<Int> {
        val active = mutableListOf<Int>()

        if (nextAdapterExist(adapter + 1)) {
            active.add(adapter + 1)
        }

        if (nextAdapterExist(adapter + 2)) {
            active.add(adapter + 2)
        }

        if (nextAdapterExist(adapter + 3)) {
            active.add(adapter + 3)
        }
        return active
    }

    private fun nextAdapterExist(number: Int): Boolean {
        return adapters.find { it == number } != null
    }
}