package main.r20.day3


fun main() {
    var countOfTrees = 0 //First tree
    var index = 1 //After first line


    loadInputData().forEachIndexed { i, line ->
        if (i % 2 == 0) {
            val forestPath = ForestPath(line, index)
            index = forestPath.getCurrentIndex(1)

            if (forestPath.isTree()) {
                countOfTrees++
                println(index)
                println(countOfTrees)
                println(line)
            }
        }
    }
    println(countOfTrees)
}


fun main1() {
    var countOfTrees = 0 //First tree
    var index = 1 //After first line
    loadInputData().forEach { line ->

        val forestPath = ForestPath(line, index)
        index = forestPath.getCurrentIndex(1)

        if (forestPath.isTree()) {
            countOfTrees++
            println(countOfTrees)
            println(line)
        }
    }
    println(countOfTrees)
}

fun loadInputData(): List<String> {
    val lineList = mutableListOf<String>();
    {}.javaClass.getResourceAsStream("/r20/day3_input.txt")!!.bufferedReader().useLines { lines ->
        lines.forEach {
            lineList.add(it)
        }
    }
    return lineList
}
