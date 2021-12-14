package main.r21.day5e

class Point(
    val x: Int,
    val y: Int,
) {
    var overide: Int = 0

    fun addOverrlay() {
        overide += 1
    }

    override fun toString(): String {
        return "$x, $y + $overide"
    }
}