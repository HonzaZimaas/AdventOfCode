package main.r21.day5

class Point(
    val x: Int,
    val y: Int
){
    override fun toString(): String {
        return "X: $x -> Y: $y"
    }
}