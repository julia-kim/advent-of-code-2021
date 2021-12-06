package days

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        val it = input.map { it.toInt() }.iterator()
        var count = 0
        var previousDepthMeasurement = it.next()
        while (it.hasNext()) {
            val depthMeasurement = it.next()
            if (depthMeasurement > previousDepthMeasurement) count++
            previousDepthMeasurement = depthMeasurement
        }
        return count
    }

    fun part2(input: List<String>): Int {
        var count = 0
        val windows = input.map { it.toInt() }.windowed(3, 1)
        val it = windows.map { it.sum() }.iterator()
        var previousSummedMeasurement = it.next()
        while (it.hasNext()) {
            val summedMeasurement = it.next()
            if (summedMeasurement > previousSummedMeasurement) count++
            previousSummedMeasurement = summedMeasurement
        }
        return count
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
