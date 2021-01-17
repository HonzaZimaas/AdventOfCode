package day5

fun main() {
    val seats = loadInputData().map(::Seat)
    seats.forEach {
        it.decodeSeat()
        println(it.toString())
        println(it.l)
        println(it.row)
        println(it.column)
        println("------------")
    }

    println(seats.sortedBy { it.calculateId() })
    println(seats.maxOf { it.calculateId() })

    var ske: Int = 8

    seats.sortedBy { it.calculateId() }.forEachIndexed { index, seat ->

        if (seat.calculateId() != 8 + index) {
            println(seat.calculateId())
            return println(seat.calculateId() -  1)
        }
    }

}

fun loadInputData(): List<String> {
    val lines = mutableListOf<String>();
    {}.javaClass.getResourceAsStream("/day5_input.txt").bufferedReader().useLines { line ->
        line.forEach { lines.add(it) }
    }
    return lines
}
