package days

import readInput
import java.util.*

fun main() {
    fun part1(input: List<String>): Int {
        var syntaxErrorScore = 0
        val map = mapOf('(' to ')', '[' to ']', '{' to '}', '<' to '>')
        var illegalChars: MutableList<Char> = mutableListOf()
        input.forEach line@{ line ->
            val stack = Stack<Char>() // last in first out

            line.forEach { ch ->
                if (map.containsKey(ch)) {
                    stack.push(map[ch])
                } else if (ch != stack.pop()) {
                    illegalChars.add(ch)
                    return@line
                }
            }
        }
        illegalChars.forEach {
            when (it) {
                ')' -> syntaxErrorScore += 3
                ']' -> syntaxErrorScore += 57
                '}' -> syntaxErrorScore += 1197
                '>' -> syntaxErrorScore += 25137
            }
        }
        return syntaxErrorScore
    }

    fun part2(input: List<String>): Long {
        val map = mapOf('(' to ')', '[' to ']', '{' to '}', '<' to '>')
        val mutableInput = input.toMutableList()
        val completionStrings: MutableList<String> = mutableListOf()
        val scores: MutableList<Long> = mutableListOf()
        mutableInput.forEach line@{ line ->
            val stack = Stack<Char>() // last in first out
            line.forEachIndexed { i, ch ->
                if (map.containsKey(ch)) {
                    stack.push(map[ch])
                } else if (ch != stack.pop()) {
                    return@line
                }
                if (i == line.lastIndex) {
                    var string = ""
                    stack.reverse()
                    stack.forEach { string += it }
                    completionStrings.add(string)
                }
            }
        }

        completionStrings.forEach {
            var totalScore = 0L
            it.forEach { ch ->
                when (ch) {
                    ')' -> totalScore = (totalScore * 5) + 1
                    ']' -> totalScore = (totalScore * 5) + 2
                    '}' -> totalScore = (totalScore * 5) + 3
                    '>' -> totalScore = (totalScore * 5) + 4
                }
            }
            scores.add(totalScore)
        }
        scores.sort()
        val middle = scores.size / 2
        return scores[middle]
    }

    val testInput = readInput("Day10_test")
    check(part1(testInput) == 26397)
    check(part2(testInput) == 288957L)

    val input = readInput("Day10")
    println(part1(input))
    println(part2(input))
}