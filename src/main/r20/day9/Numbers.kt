package main.r20.day9


class Numbers(private val lines: List<Long>) {
    private val preambule = 25
    private val magic = 85848519


    fun count() {
        var invalid = 0L
        for (line in preambule.until(lines.size)) {
            val listOfSum = countSumOfRange(line - preambule, line)
            if (!listOfSum.contains(lines[line])) {
                invalid = lines[line]
                println("-----------------")
                println(line + 1)
                println(lines[line])
                println("-------aaaaa----------")
            }
        }
        imagine(invalid)
    }


    private fun imagine(invalid: Long) {
        lines.forEachIndexed { index, line ->
            var num = 0L
            for (number in index until lines.size) {
                num += lines[number]

                if (num == invalid) {
                    val list = lines.subList(index, number + 1)
                    println("--------1---------")
                    println(lines[number])
                    println("-----------------")
                    println(list.maxOf { it })
                    println("-----------------")
                    println(list.minOf { it })
                    println("-----------------")
                    println(list.minOf { it } + list.maxOf { it })
                }

                if (num > invalid) {
                    break
                }
            }
        }
    }


    private fun countSumOfRange(from: Int, to: Int): List<Long> {
        val list = mutableListOf<Long>()
        for (l in from until to) {
            list.add(lines[l])
        }
        return countTogether(list)
    }

    private fun countTogether(numbers: List<Long>): List<Long> {
        val list = mutableListOf<Long>()
        for (number in numbers.indices) {
            numbers.forEach {
                list.add(it + numbers[number])
            }
        }
        return list.distinct()
    }
}


