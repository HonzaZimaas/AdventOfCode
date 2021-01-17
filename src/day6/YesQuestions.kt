package day6

fun main() {
    val blockAnswers = loadInputData().map(::BlockOfAnswers)
    var count = 0
    var count2 = 0

    blockAnswers.forEach {
        count += it.countOfYesAnswersPerGroup()
        count2 += it.countOfYesQuestionsInGroup()
    }
    println(count)
    println(count2)
}

fun loadInputData(): List<String> {
    val string = {}.javaClass.getResourceAsStream("/day6_input.txt").bufferedReader().readText()
    return string.split("\n\n")
}