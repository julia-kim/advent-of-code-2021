package days

import readInput
import kotlin.math.absoluteValue

fun main() {
    fun part1(input: List<String>): Int {
        val horizontalPositions = input[0].split(",").map { it.toInt() }
        val outcomes: MutableList<Int> = mutableListOf()
        horizontalPositions.forEach { pos ->
            var totalFuel = 0
            horizontalPositions.forEach {
                val diff = (it - pos).absoluteValue
                totalFuel += diff
            }
            outcomes.add(totalFuel)
        }
        return outcomes.minOf { it }
    }

    fun part2(input: List<String>): Int {
        val horizontalPositions = input[0].split(",").map { it.toInt() }
        val outcomes: MutableList<Int> = mutableListOf()
        (0..horizontalPositions.maxOf { it }).forEach { pos ->
            var totalFuel = 0
            horizontalPositions.forEach {
                var fuelCost = 0
                var diff = (it - pos).absoluteValue
                while (diff > 0) {
                    fuelCost += diff
                    diff--
                }
                totalFuel += fuelCost
            }
            outcomes.add(totalFuel)
        }
        return outcomes.minOf { it }
    }

    val testInput = readInput("Day07_test")
    check(part1(testInput) == 37)
    check(part2(testInput) == 168)

    val input = readInput("Day07")
    println(part1(input))
    println(part2(input))
}