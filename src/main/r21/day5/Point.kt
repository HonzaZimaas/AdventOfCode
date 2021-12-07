package main.r21.day5

class Point(
    val x: Int,
    val y: Int,
) {
    var overide: Int = 0

    fun setOveride() {
        overide += 1
    }

    override fun toString(): String {
        return "X: $x -> Y: $y"
    }
}