package day7

class BugsWithCount(private val lines: List<String>) {
    private var map = mutableMapOf<String, HashMap<String, Int>>()

    fun parseLinesColorNames() {
        lines.forEach { line ->
            val mainColor = line.substringBefore(" bag")
            val containedColors = line.substringAfter("contain ")
                .replace("bags", "")
                .replace("bag", "")
                .removePrefix(" ")
                .removeSuffix(" .")
                .split(", ")


            val mapWithNumber = HashMap<String, Int>()
            containedColors.forEach { color ->
                mapWithNumber[color.filterNot { it.isDigit() }.removePrefix(" ").removeSuffix(" ")] =
                    color.filter { it.isDigit() }.toIntOrNull() ?: 0
            }
            map[mainColor] = mapWithNumber
        }
    }

    fun countOfBagsThatCanContainShinyGold(): Int {
        return findBags("shiny gold") - 1
    }

    private fun findBags(color: String): Int {
        val bags = map[color]

        if (bags!!.contains("no other")) {
            return 1
        }
        return 1 + bags.entries.sumOf {
            findBags(it.key) * it.value
        }
    }
}
