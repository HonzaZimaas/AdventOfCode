package main.r20.day11

import com.sun.jdi.InvalidTypeException

class AirportSeats(private val lines: List<String>) {
    private val listOfSeats = mutableListOf<Seat>()
    var previousCountOfFullSeats = -1

    fun creatInitialAirportSeatsState() {
        createAirportSeatsMap()
        findOutSeatsNeighbors()
    }

    fun nextMove(part: String) {
        listOfSeats.filter { it.currentState != SeatState.NON }.forEach { seat ->
            val currentValuer = if (part == "PART1") seat.countNeighborsCurrentValue() else seat.countValueOfAllVisibleChar()
            chooseNextState(currentValuer, seat, part)
        }
        listOfSeats.filter { it.currentState != SeatState.NON }.forEach { seat ->
            seat.changeState()
        }
    }

    fun findIfSeatStatusChanged(): Boolean {
        val countOfFullSeats = getCountOfFullSeats()
        return if (previousCountOfFullSeats != countOfFullSeats) {
            previousCountOfFullSeats = countOfFullSeats
            true
        } else false
    }

    private fun getCountOfFullSeats(): Int {
        return listOfSeats.count { it.currentState == SeatState.FULL }
    }

    private fun createAirportSeatsMap() {
        lines.forEachIndexed { rowIndex: Int, row: String ->
            row.forEachIndexed { columnIndex, column ->
                val seat = Seat(rowIndex, columnIndex, getInitialState(column))
                listOfSeats.add(seat)
            }
        }
    }

    private fun getInitialState(char: Char): SeatState {
        when (char.toString()) {
            "L" -> return SeatState.EMPTY
            "#" -> return SeatState.FULL
            "." -> return SeatState.NON
        }
        throw InvalidTypeException("Could not resolve Seat State of...")
    }

    private fun findOutSeatsNeighbors() {
        listOfSeats.forEach { seat ->
            seat.neighbors.addAll(getNeighbors(seat))
        }
    }

    private fun getNeighbors(seat: Seat): List<Seat> {
        return listOfSeats
                .filter { it.x in seat.x - 1..seat.x + 1 && it.y in seat.y - 1..seat.y + 1 }
                .filterNot { it.x == seat.x && it.y == seat.y }
    }

    private fun chooseNextState(value: Int, seat: Seat, part: String) {
        if (value == 0) {
            seat.nextState = SeatState.FULL
        }

        if (value > getTollerance(part) && seat.currentState == SeatState.FULL) {
            seat.nextState = SeatState.EMPTY
        }
    }

    private fun getTollerance(part: String): Int {
        return if (part == "PART1") 3 else 4
    }
}