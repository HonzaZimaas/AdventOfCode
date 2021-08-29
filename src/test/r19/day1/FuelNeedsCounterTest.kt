package test.r19.day1

import main.r19.Utils.Utils
import main.r19.day1.FuelNeedsCounter
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*


internal class FuelNeedsCounterTest {
    private val fuelNeedsCounter = FuelNeedsCounter()

    @Test
    fun getFuelSimpleTest() {
        //when
        val fuelMass = 1969
        val sumOfFuel = fuelNeedsCounter.getFuelSimple(fuelMass)

        //then
        assertEquals(654, sumOfFuel)
    }

    @Test
    fun getFuelRecursivelyTes() {
        //when
        val fuelMass = 100756
        val sumOfFuel = fuelNeedsCounter.getFuelRecursively(fuelMass)

        //then
        assertEquals(50346, sumOfFuel)
    }

    @Test
    fun getSumOfFuelIntegrationTest() {
        //when
        val inpuStream = Utils().loadInputData("/r19/day1_input.txt")
        val resultsMap: Map<String, Int> = FuelNeedsCounter().getSumOfFuel(inpuStream)

        //then
        assertEquals(3262356, resultsMap["simple"])
        assertEquals(4890664, resultsMap["recursively"])
    }
}

