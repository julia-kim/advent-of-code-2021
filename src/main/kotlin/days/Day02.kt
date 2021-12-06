package days

import readInput

fun main() {
    fun part1(input: List<String>): Int {

//        - forward X increases the horizontal position by X units.
//        - down X increases the depth by X units.
//        - up X decreases the depth by X units.

        var horizontalPosition = 0
        var depth = 0
        input.forEach { command ->
            val (direction, number) = command.split(" ")
            when (direction) {
                ("forward") ->
                    horizontalPosition += number.toInt()
                ("down") ->
                    depth += number.toInt()
                ("up") ->
                    depth -= number.toInt()
            }
        }
        return horizontalPosition * depth
    }

    fun part2(input: List<String>): Int {

//        - down X increases your aim by X units.
//        - up X decreases your aim by X units.
//        - forward X does two things:
//              - It increases your horizontal position by X units.
//              - It increases your depth by your aim multiplied by X.

        var aim = 0
        var horizontalPosition = 0
        var depth = 0
        input.forEach { command ->
            val (direction, number) = command.split(" ")
            when (direction) {
                ("forward") -> {
                    horizontalPosition += number.toInt()
                    depth += number.toInt() * aim
                }
                ("down") ->
                    aim += number.toInt()
                ("up") ->
                    aim -= number.toInt()
            }
        }
        return horizontalPosition * depth
    }

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
