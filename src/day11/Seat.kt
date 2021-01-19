package day11

class Seat(var x: Int, var y: Int, var currentState: SeatState) {
    lateinit var nextState: SeatState
    var neighbors = mutableListOf<Seat>()

    fun changeState() {
        //    println("$x, $y : $currentState -> $nextState")
        currentState = nextState
    }

    fun countNeighborsCurrentValue(): Int {
        return neighbors.count { it.currentState == SeatState.FULL }
    }

    fun countValueOfAllVisibleChar(): Int {
        val fullAround = neighbors.count { it.currentState == SeatState.FULL }
        var countOfRemote = 0

        neighbors.filter { it.currentState == SeatState.NON }.forEach { neighbor ->
            var neigh = neighbor

            while (neigh.currentState == SeatState.NON) {
                //println("$x, $y -> ${neigh.x}, ${neigh.y} : ${neigh.currentState}")
                val newX = neighbor.x - x
                val newY = neighbor.y - y

                val seat = neigh.neighbors.firstOrNull { it.x == neigh.x + newX && it.y == neigh.y + newY } ?: break
                if (seat.currentState == SeatState.NON) {
                    neigh = seat
                } else {
                    if (seat.currentState == SeatState.FULL) {
                        countOfRemote ++
                    }
                    break
                }
            }
        }
        return fullAround + countOfRemote
    }
}