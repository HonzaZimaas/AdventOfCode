package main.r21.day4

class BingoTable(private val table: String) {

    private var rows = mutableListOf<List<Int>>()
    private var columns = mutableListOf<List<Int>>()
    var isDone = false

    init {
        parseRowsFromTable(table)
        createColumnsFromRows()
    }

    fun findRowsOrColumns(numbers: List<Int>): Boolean {
        rows.forEach { row ->
            if (numbers.containsAll(row)) {
                println(row)
                isDone = true
                return true
            }
        }

        columns.forEach { column ->
            if (numbers.containsAll(column)) {
                println(column)
                isDone = true
                return true
            }
        }
        return false
    }

    fun countValues(numbers: List<Int>): Int {
        val sum = numbers.sum()
        var tableSum = 0
        rows.forEach {
            tableSum += it.sum()
        }

        numbers.forEach { number ->
            rows.forEach { row ->
                if (row.contains(number)) {
                    tableSum -= number
                }
            }
        }

        return tableSum
    }

    private fun parseRowsFromTable(table: String) {
        table.split("\r\n").filter { it.isNotBlank() }.forEach { row ->
            rows.add(row.split(" ").filter { it.isNotBlank() }.map { it.toInt() })
        }
    }

    private fun createColumnsFromRows() {
        for (i in 0 until rows.size) {
            val list = mutableListOf<Int>()
            rows.forEach { number ->
                list.add(number[i])
            }
            columns.add(list)
        }
    }

    override fun toString(): String {
        return "Table: \n\r Rows: $rows \n\r Columns: $columns"
    }
}