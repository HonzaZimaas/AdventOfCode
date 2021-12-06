package main.r21.day4

fun main() {
    val bingoInstruction: String =
        {}.javaClass.getResourceAsStream("/r21/day4/input.txt")!!.bufferedReader().readText()


    val invocationNumbers = bingoInstruction.substringBefore("\r\n").split(",").map { it.toInt() }
    //println(invocationNumbers)

    val bingoTables = bingoInstruction.substringAfter("\r\n").split("\r\n\r\n").map(::BingoTable)
    //println(bingoTables)

    for (number in 4 until invocationNumbers.size) {
        val list = invocationNumbers.subList(0, number)
        println(list)
        bingoTables.forEach { table ->
            if (table.findRowsOrColumns(list)) {
                println(table)
                val count = table.countValues(list)
                println(count)
                println(list[number - 1])
                println(list[number - 1] * count)
            }
            if (bingoTables.count { it.isDone } == bingoTables.size) {
                println(table)
                val count = table.countValues(list)
                println(count)
                println(list[number - 1])
                println(list[number - 1] * count)
                return
            }
        }
    }
}

