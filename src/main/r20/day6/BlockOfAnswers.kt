package main.r20.day6

class BlockOfAnswers(private val line: String) {

    fun countOfYesAnswersPerGroup(): Int {
        return line.filter { it.isLetter() }.toMutableList().distinct().size
    }

    fun countOfYesQuestionsInGroup(): Int {
        return fillterSameQuestions(line.split("\n"))
    }

    private fun fillterSameQuestions(list: List<String>): Int {
        var str = ""
        list.forEach {
            str += it
        }
        return str.toMutableList().groupingBy { it }.eachCount().filter { it.value == list.size }.size
    }
}