package main.r19.day1

import main.r19.Utils.Utils
import java.io.InputStream

fun main() {
    val inputStream: InputStream = Utils().loadInputData("/r19/day1_input.txt")
    val resultsMap: Map<String, Int> = FuelNeedsCounter().getSumOfFuel(inputStream)

    println("Sum of Fuel - simple: ${resultsMap["simple"]}")
    println("Sum of Fuel - recursively: ${resultsMap["recursively"]}")
}


