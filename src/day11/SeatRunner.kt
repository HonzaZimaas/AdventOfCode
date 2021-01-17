package day11

fun main() {
    val lines = loadInputData()
    val airportSeats = AirportSeats(lines)
    airportSeats.creatInitialAirportSeatsState()

    while (airportSeats.findIfSeatStatusChanged()) {
        airportSeats.nextMove()
        println("------${airportSeats.previousCountOfFullSeats}---------")
    }
}

fun loadInputData(): List<String> {
    val string = {}.javaClass.getResourceAsStream("/day11_input.txt").bufferedReader().readText().split("\n")
    return string.map { it }
}
