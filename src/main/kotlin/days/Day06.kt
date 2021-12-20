package days

import readInput

fun main() {
    fun part1(input: List<String>): Long {
        val school = input[0].split(",").map { it.toInt() }.toMutableList()
        var iterator: MutableListIterator<Int>
        var days = 80
        while (days > 0) {
            iterator = school.listIterator()
            while (iterator.hasNext()) {
                val lanternfish = iterator.next()
                if (lanternfish == 0) {
                    iterator.set(6); iterator.add(8)
                } else {
                    iterator.set(lanternfish - 1)
                }
            }
            days--
        }
        return school.size.toLong()
    }

    fun part2(input: List<String>): Long {
        return 0L
    }

    val testInput = readInput("Day06_test")
    check(part1(testInput) == 5934L)
//    check(part2(testInput) == 26984457539L)

    val input = readInput("Day06")
    println(part1(input))
//    println(part2(input))
}