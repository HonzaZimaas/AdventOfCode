package main.r20.day11

fun main() {
    println("------PART1---------")
    val airportSeats = AirportSeats(loadInputData())
    airportSeats.creatInitialAirportSeatsState()

    while (airportSeats.findIfSeatStatusChanged()) {
        airportSeats.nextMove("PART1")
        println("------${airportSeats.previousCountOfFullSeats}---------")
    }

    println("------PART2---------")

    val airportSeatsPart2 = AirportSeats(loadInputData())
    airportSeatsPart2.creatInitialAirportSeatsState()

    while (airportSeatsPart2.findIfSeatStatusChanged()) {
        airportSeatsPart2.nextMove("PART2")
        println("------${airportSeatsPart2.previousCountOfFullSeats}---------")
    }

}

fun loadInputData(): List<String> {
    val string = {}.javaClass.getResourceAsStream("/r20/day11_input.txt")!!.bufferedReader().readText().split("\n")
    return string.map { it.replace("\r","") }
}
