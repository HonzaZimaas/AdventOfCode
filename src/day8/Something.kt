package day8

fun main() {

    val something = SomeClass(loadInputData())
    println("-----------")
    something.findInitialLoop(loadInputData())
    println("-----------")

    println("-----------")
    something.modifySomethingAndCheckLoop()
    println("-----------")
}


fun loadInputData(): List<String> {
    val string = {}.javaClass.getResourceAsStream("/day8_input.txt").bufferedReader().readText()
    return string.split("\n")
}