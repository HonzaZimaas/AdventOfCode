package main.r21.day3

import javax.print.attribute.IntegerSyntax


fun main() {
    val bits: List<String> =
        {}.javaClass.getResourceAsStream("/r21/day3/input.txt")!!.bufferedReader().readLines()

    //getBist(bits)

    val oxygen = getOxygen(bits)
    println(oxygen)
    val co = getCo(bits)
    println(co)
    println(oxygen * co)
}

private fun getOxygen(bits: List<String>): Int {

    var updatedList = bits

    for (coluumn in 0 until bits.first().length) {
        val higherNumber = getCurrentBineryPressence(updatedList, coluumn)

        val list = if (higherNumber == 0) {
            updatedList.filter { it[coluumn].toString() == "0" }
        } else {
            updatedList.filter { it[coluumn].toString() == "1" }
        }
        updatedList = list

        println(updatedList)
        if (updatedList.size == 1) {
            println(updatedList.first())
            return Integer.parseInt(updatedList.first(), 2)
        }
    }
    return 0
}

private fun getCo(bits: List<String>): Int {

    var updatedList = bits

    for (coluumn in 0 until bits.first().length) {
        val higherNumber = getCurrentBineryPressence(updatedList, coluumn)

        val list = if (higherNumber == 1) {
            updatedList.filter { it[coluumn].toString() == "0" }
        } else {
            updatedList.filter { it[coluumn].toString() == "1" }
        }
        updatedList = list

        println(updatedList)
        if (updatedList.size == 1) {
            println(updatedList.first())
            return Integer.parseInt(updatedList.first(), 2)
        }
    }

    return 0
}


private fun getCurrentBineryPressence(list: List<String>, index: Int): Int {
    var nula = 0
    var jedna = 0

    list.forEach { bit ->
        val get = bit[index]
        if (get.toString() == "0") {
            nula += 1
        }
        if (get.toString() == "1") {
            jedna += 1
        }
    }
    return if (nula > jedna) 0 else 1
}


private fun getBist(bits: List<String>) {
    val listOfResutlt = mutableListOf<Int>()

    for (coluumn in 0 until bits.first().length) {
        var nula = 0
        var jedna = 0

        bits.forEach { bit ->
            val get = bit[coluumn]
            if (get.toString() == "0") {
                nula += 1
            }

            if (get.toString() == "1") {
                jedna += 1
            }
        }

        if (nula > jedna) {
            listOfResutlt.add(0)
        } else {
            listOfResutlt.add(1)
        }
        println(listOfResutlt)
    }
    val firtResult = listOfResutlt.joinToString("")
    println(firtResult)
    val int = Integer.parseInt(firtResult, 2)
    println(int)

    var secondResult = ""

    listOfResutlt.joinToString("").forEach { char ->
        if (char.toString() == "0") {
            secondResult += "1"
        } else {
            secondResult += "0"
        }
    }
    println(secondResult)
    val int2 = Integer.parseInt(secondResult, 2)
    println(int2)

    println(int * int2)


}