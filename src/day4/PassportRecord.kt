package day4

class PassportRecord(private val record: String) {

    private val byr = parseFields("byr")
    private val iyr = parseFields("iyr")
    private val eyr = parseFields("eyr")
    private val hgt = parseFields("hgt")
    private val hcl = parseFields("hcl")
    private val ecl = parseFields("ecl")
    private val pid = parseFields("pid")
    private val cid = parseFields("cid")

    fun isPassportValidNull(): Boolean {
        val mustBeNotNull = arrayOf(byr, iyr, eyr, hgt, hcl, ecl, pid)
        return mustBeNotNull.size == mustBeNotNull.filterNotNull().size
    }

    fun isPassportValidWithCorrectType(): Boolean {
        if (isPassportValidNull()) {
            return validateValues()
        }
        return false
    }

    private fun validateValues(): Boolean {
        return validateInt(byr!!, 1920, 2002) &&
                validateInt(iyr!!, 2010, 2020) &&
                validateInt(eyr!!, 2020, 2030) &&
                validateHeight(hgt!!) &&
                validateHairColor(hcl!!) &&
                validateEyeColor(ecl!!) &&
                validateDigit(pid!!)
    }

    private fun validateDigit(string: String): Boolean {
        val str = getSuffix(string)

        if (str.length == 9) {
            return str.all { it.isDigit() }
        }
        return false
    }

    private fun validateEyeColor(string: String): Boolean {
        val str = getSuffix(string)
        val colors = arrayOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
        return colors.any { it == str }
    }

    private fun validateHairColor(string: String): Boolean {
        val str = getSuffix(string)
        val regexp = Regex("([a-f0-9]*)")

        if (str.length == 7 && str.startsWith("#")) {
          return  str.slice(1 until str.length).matches(regexp)
        }
        return false
    }

    private fun validateHeight(string: String): Boolean {
        val str = getSuffix(string)

        return if (str.endsWith("cm")) {
            str.filter { it.isDigit() }.toIntOrNull()?.let { it in 150..193 } ?: false
        } else {
            str.filter { it.isDigit() }.toIntOrNull()?.let { it in 59..76 } ?: false
        }
    }

    private fun validateInt(string: String, since: Int, to: Int): Boolean {
        return getSuffix(string).toIntOrNull()?.let { it in since..to } ?: false
    }

    private fun parseFields(prefix: String): String? {
        return record.split(" ", "\n").find { it.startsWith(prefix) }
    }

    private fun getSuffix(string: String): String {
        return string.slice(4 until string.length)
    }
}