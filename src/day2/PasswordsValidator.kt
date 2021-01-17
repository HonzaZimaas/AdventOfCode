package day2

fun main() {
    val passwords = loadInputData().map(::Password)

    println(passwords.count { it.isPasswordValid() })
    println(passwords.count { it.isPassValidByLocation() })
}

fun loadInputData(): List<String> {
    val lineList = mutableListOf<String>();
    {}.javaClass.getResourceAsStream("/day2_input.txt").bufferedReader().useLines { lines ->
        lines.forEach {
            lineList.add(it)
        }
    }
    return lineList
}
