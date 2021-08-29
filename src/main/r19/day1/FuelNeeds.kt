package main.r19.day1

import java.io.InputStream
import kotlin.math.*

fun main() {
    val inputStream: InputStream = loadInputData()
    val resultsMap: Map<String, Int> = getSumOfFuelSimple(inputStream)

    println("Sum of Fuel - simple: ${resultsMap["simple"]}")
    println("Sum of Fuel - recursively: ${resultsMap["recursively"]}")
}

private fun loadInputData(): InputStream {
    return {}.javaClass.getResourceAsStream("/r19/day1_input.txt")!!
}

private fun getSumOfFuelSimple(inputStream: InputStream): Map<String, Int> {
    var sumOfFuelSimple = 0
    var sumOfFuelRecursively = 0

    inputStream.bufferedReader().forEachLine { line ->
        sumOfFuelSimple += countFuel(getFuelMass(line))
        sumOfFuelRecursively += getFuelRecursively(getFuelMass(line))
    }
    return mapOf("simple" to sumOfFuelSimple, "recursively" to sumOfFuelRecursively)
}

private fun getFuelRecursively(fuelMass: Int): Int {
    var sumOfFuel = 0
    var tempFuelMass = fuelMass

    while (tempFuelMass > 0) {
        tempFuelMass = countFuel(tempFuelMass)
        if (tempFuelMass.sign == 1) {
            sumOfFuel += tempFuelMass
        }
    }
    return sumOfFuel
}

private fun countFuel(fuelMass: Int): Int {
    return round(fuelMass.div(3).toDouble()).toInt() - 2
}

private fun getFuelMass(line: String): Int {
    return line.toInt()
}


