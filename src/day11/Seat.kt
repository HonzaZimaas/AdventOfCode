package day11

class Seat(var x: Int, var y: Int, var currentState: SeatState) {
    lateinit var nextState: SeatState
    var neighbors = mutableListOf<Seat>()

    fun changeState() {
        println("$x, $y : $currentState -> $nextState")
        currentState = nextState
    }

    fun countNeighborsCurrentValue(): Int {
        return neighbors.count { it.currentState == SeatState.FULL }
    }
}