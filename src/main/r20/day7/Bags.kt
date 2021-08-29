package main.r20.day7

class Bags(private val lines: List<String>) {
    private var map = mutableMapOf<String, List<String>>()
    private var listOfColors = mutableListOf<String>()
    private var listOfColorsWithShiny = mutableListOf<String>()

    fun parseLinesColorNames() {
        lines.forEach { line ->
            val mainColor = line.substringBefore(" bag")
            val containedColors = line.substringAfter("contain ")
                .replace("bags", "")
                .replace("bag", "")
                .filterNot { it.isDigit() }
                .removePrefix(" ")
                .removeSuffix(" .")
                .split(" ,  ")
            map[mainColor] = containedColors
        }
    }

    fun colorsThatCanBeInShinyGold(): Int {
        return listOfColors.distinct().size
    }

    fun colorsWhereCanBeShinyGold(): Int {
        return listOfColorsWithShiny.distinct().size
    }

    fun findAllColorsWhereCanBeShinyGold() {
        lines.forEach { line ->
            var nodes = listOf(line.substringBefore(" bag"))

            while (nodes.isNotEmpty()) {
                nodes = findNextNodes(nodes, line)
            }
        }
    }

    private fun findNextNodes(nodes: List<String>, line: String): List<String> {
        val updatedList = mutableListOf<String>()

        nodes.forEach { colors ->
            map[colors]!!.forEach { color ->
                if (color != "no other") {
                    updatedList.add(color)
                    if (color == "shiny gold") {
                        listOfColorsWithShiny.add(line.substringBefore(" bag"))
                        return mutableListOf()
                    }
                }
            }
            updatedList.removeAll { it == "no other" }
        }
        return updatedList
    }

    fun findAllColorsThatCanBeInShinyGold() {
        var nodes = listOf("shiny gold")

        while (nodes.isNotEmpty()) {
            nodes = findNextNodes(nodes)
        }
    }

    private fun findNextNodes(nodes: List<String>): List<String> {
        val updatedList = mutableListOf<String>()

        nodes.forEach { colors ->
            map[colors]!!.forEach { color ->
                if (color != "no other") {
                    listOfColors.add(color)
                    updatedList.add(color)
                }
            }
            updatedList.removeAll { it == "no other" }
        }
        return updatedList
    }
}