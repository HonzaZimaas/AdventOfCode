package main.r20.day7

fun main() {
    val bags = Bags(loadInputData())
    bags.parseLinesColorNames()

    bags.findAllColorsThatCanBeInShinyGold()

    println("------------")
    println(bags.colorsThatCanBeInShinyGold())
    println("------------")

    bags.findAllColorsWhereCanBeShinyGold()

    println("------------")
    println(bags.colorsWhereCanBeShinyGold())
    println("------------")

    val bugsWithCount = BugsWithCount(loadInputData())
    bugsWithCount.parseLinesColorNames()

    println("------------")
    println(bugsWithCount.countOfBagsThatCanContainShinyGold())
    println("------------")
}

fun loadInputData(): List<String> {
    val string = {}.javaClass.getResourceAsStream("/r20/day7_input.txt")!!.bufferedReader().readText()
    return string.split("\n")
}
