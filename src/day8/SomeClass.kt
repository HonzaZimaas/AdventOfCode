package day8

class SomeClass(private val linesss: List<String>) {
    var global = 0

    fun modifySomethingAndCheckLoop() {
        linesss.forEachIndexed { index, modifyLine ->
            val lines = changeLinePrefix(index, modifyLine)
            global = findFirstLoop(lines)
            //println("$global + global")

            if (global != 0) {
                println("$modifyLine -> ${lines[index]}")
                println(global)
            }
        }
    }

    private fun changeLinePrefix(index: Int, modifyLine: String): List<String> {
        val list = mutableListOf<String>()
        list.addAll(linesss)

//        if (getLinePrefix(modifyLine) == "nop") {
//            list[index] = list[index].replace("nop", "jmp")
//            return list
//        }

        if (getLinePrefix(modifyLine) == "jmp") {
            list[index] = list[index].replace("jmp", "nop")
            //println("$modifyLine -> ${list[index]}")
            return list
        }

        return list
    }

    fun findFirstLoop(lines: List<String>): Int {
        var index = 0
        var glob = 0
        val indexes = mutableListOf<Int>()

        while (index < lines.size) {
            if (indexes.contains(index)) {
               // println("Sem to nemůže jít ještě $index")
                return 0
            } else {
                indexes.add(index)
                when (getLinePrefix(lines[index])) {
                    "acc" -> glob += getLineValue(lines[index])
                    "nop" -> glob += 0
                    "jmp" -> index += getLineValue(lines[index]) - 1
                }
                index++
            }
        }
        return glob
    }


    fun findInitialLoop(lines: List<String>) {
        var index = 0
        val indexes = mutableListOf<Int>()
        var glob = 0
        while (index < lines.size) {
            if (indexes.contains(index)) {
                println(glob)
                index = lines.size
            } else {
                indexes.add(index)
                when (getLinePrefix(lines[index])) {
                    "acc" -> glob += getLineValue(lines[index])
                    "nop" -> glob += 0
                    "jmp" -> index += getLineValue(lines[index]) - 1
                }
                index++
            }
        }
    }

    private fun getLinePrefix(line: String): String {
        return line.substringBefore(" ")
    }

    private fun getLineValue(line: String): Int {
        if (line.contains("-")) {
            return line.filter { it.isDigit() }.toInt() * -1
        }
        return line.filter { it.isDigit() }.toInt()
    }
}