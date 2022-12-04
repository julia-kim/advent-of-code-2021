package days

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        var stepCount = 0
        var polymerTemplate = input[0]
        val pairInsertionRules = input.subList(2, input.size)
        while (stepCount < 10) {
            val pairs = polymerTemplate.windowed(2)
            polymerTemplate = pairs.mapIndexed { i, pair ->
                val rule = pairInsertionRules.first {
                    pair == it.take(2)
                }
                val (_, element) = rule.split(" -> ")
                val str = StringBuilder(pair).apply {
                    insert(1, element)
                }.toString()
                if (i == pairs.lastIndex) str else str.take(2)
            }.joinToString().filter { it.isLetter() }
            stepCount++
        }
        val distinctElements = polymerTemplate.toList().distinct()
        val charsMap = mutableMapOf<Char, Int>()
        distinctElements.forEach { c ->
            charsMap[c] = polymerTemplate.count { it == c }
        }
        return charsMap.values.maxOf { it } - charsMap.values.minOf { it }
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    val testInput = readInput("Day14_test")
    check(part1(testInput) == 1588)
    check(part2(testInput) == 0)

    val input = readInput("Day14")
    println(part1(input))
    println(part2(input))
}