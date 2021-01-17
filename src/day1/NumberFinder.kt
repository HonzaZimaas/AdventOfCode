package day1

import java.io.InputStream

fun main() {
    val lineList = mutableListOf<Int>()
    val inputStream: InputStream =  {}.javaClass.getResourceAsStream("/day1_input.txt")

    inputStream.bufferedReader().useLines { lines ->
        lines.forEach {
            lineList.add(it.toInt())
        }
    }

    for (number in lineList) {
        for (addition in lineList) {
            for (nextAddition in lineList) {
                val sum: Int = number + addition + nextAddition
                if (sum == 2020) {
                    println("<<<<<<<<---2020--->>>>>>>>")
                    println(number)
                    println(addition)
                    println(nextAddition)
                    println("MULTI: " + number * addition * nextAddition)
                }
            }
        }
    }
}
