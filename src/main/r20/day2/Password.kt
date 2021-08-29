package main.r20.day2

class Password(private val line: String) {

    private val letter = parseLetter()
    private val range = parse()
    private val password = parsePassword()


    private fun parse(): List<String> {
        return line.split(" ")[0].split("-")
    }

    private fun parseLetter(): String {
        return line.split(" ")[1].filter { it.isLetter() }
    }

    private fun parsePassword(): String {
        return line.split(" ")[2]
    }

    fun isPasswordValid(): Boolean {
        val count = password.filter { it == letter.first() }.count()
        return range[0].toInt() <= count && count <= range[1].toInt()
    }

    fun isPassValidByLocation(): Boolean {
        return ((password[range[0].toInt() - 1 ]).toString() == letter && (password[range[1].toInt() - 1]).toString() != letter) ||
                ((password[range[1].toInt() - 1]).toString() == letter && (password[range[0].toInt() - 1]).toString() != letter)
    }
}
