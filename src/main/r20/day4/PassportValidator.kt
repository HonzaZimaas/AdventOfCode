package main.r20.day4

fun main() {
    val passport = loadInputData().map(::PassportRecord)

    println(passport.count { it.isPassportValidNull() })
    println(passport.count { it.isPassportValidWithCorrectType() })
}

fun loadInputData(): List<String> {
    val string = {}.javaClass.getResourceAsStream("/r20/day4_input.txt")!!.bufferedReader().readText()
    return string.split("\n\n")
}