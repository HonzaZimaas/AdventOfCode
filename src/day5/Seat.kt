package day5

class Seat(private val line: String) {
    var row: Int? = null
    var column: Int? = null

    private var basicRow = 128
    private var rowFrom = 0
    private var rowTo = 127

    private var basicColumn = 8
    private var columnFrom = 0
    private var columnTo = 7

    val l = line

    @Override
    override fun toString(): String {
        return calculateId().toString()
    }

    fun decodeSeat() {
        for (i in 0.until(7)) {
            getNewRange(getLetter(i))
        }
        row = getFinalRow()

        for (i in 0.until(3)) {
            getCurrentColumn(getLetter(7 + i))
        }
        column = getFinalColumn()
    }

    fun calculateId(): Int {
        return row!! * 8 + column!!
    }

    private fun getFinalColumn(): Int {
        return if (getLetter(9) == "L")
            columnFrom else columnTo
    }

    private fun getFinalRow(): Int {
        return if (getLetter(6) == "F")
            rowFrom else rowTo
    }

    private fun getCurrentColumn(str: String) {
        basicColumn /= 2
        if (str == "L") {
            columnTo -= basicColumn
        } else {
            columnFrom += basicColumn
        }
    }

    private fun getNewRange(str: String) {
        basicRow /= 2
        if (str == "F") {
            rowTo -= basicRow
        } else {
            rowFrom += basicRow
        }
    }

    private fun getLetter(index: Int): String {
        return line[index].toString()
    }
}