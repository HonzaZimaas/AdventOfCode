package day3

class ForestPath(private val line: String, private val previousIndex: Int) {
    var cislo = true

    fun getCurrentIndex(nextRight: Int): Int {
        var current = previousIndex + nextRight
        if (current > line.length) {
            current -= line.length
        }
        return current
    }

    fun isTree(): Boolean {
        return line[previousIndex - 1].toString() == "#"
    }
}