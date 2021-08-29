package main.r19.day1

import java.io.InputStream
import kotlin.math.round
import kotlin.math.sign

class FuelNeedsCounter {

    fun getSumOfFuel(inputStream: InputStream): Map<String, Int> {
        var sumOfFuelSimple = 0
        var sumOfFuelRecursively = 0

        inputStream.bufferedReader().forEachLine { line ->
            sumOfFuelSimple += getFuelSimple(getFuelMass(line))
            sumOfFuelRecursively += getFuelRecursively(getFuelMass(line))
        }
        return mapOf("simple" to sumOfFuelSimple, "recursively" to sumOfFuelRecursively)
    }

    internal fun getFuelSimple(fuelMass: Int): Int {
        return countFuel(fuelMass)
    }

    internal fun getFuelRecursively(fuelMass: Int): Int {
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
}