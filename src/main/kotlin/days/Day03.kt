package days

import readInput

fun main() {
    fun part1(input: List<String>): Long {
        var gammaRate = ""
        var epsilonRate = ""
        var i = 0
        while (i < input[0].length) {
            val bits = input.map { it[i] }.groupingBy { it }.eachCount()
            gammaRate += bits.maxByOrNull { it.value }!!.key
            epsilonRate += bits.minByOrNull { it.value }!!.key
            i++
        }
        val powerConsumption = gammaRate.toLong(2) * epsilonRate.toLong(2)
        return powerConsumption
    }

    fun part2(input: List<String>): Long {
        var oxygenGeneratorRating = input
        var co2ScrubberRating = input
        var i = 0
        while (oxygenGeneratorRating.size > 1) {
            val bits = oxygenGeneratorRating.map { it[i] }
            val zeroCount = bits.count { it == '0' }
            val oneCount = bits.count { it == '1' }
            oxygenGeneratorRating = if (zeroCount <= oneCount) {
                oxygenGeneratorRating.filter { it[i] == '0' }
            } else {
                oxygenGeneratorRating.filter { it[i] == '1' }
            }
            i++
        }
        var j = 0
        while (co2ScrubberRating.size > 1) {
            val bits = co2ScrubberRating.map { it[j] }
            val zeroCount = bits.count { it == '0' }
            val oneCount = bits.count { it == '1' }
            co2ScrubberRating = if (zeroCount > oneCount) {
                co2ScrubberRating.filter { it[j] == '0' }
            } else {
                co2ScrubberRating.filter { it[j] == '1' }
            }
            j++
        }
        val lifeSupportRating = oxygenGeneratorRating[0].toLong(2) * co2ScrubberRating[0].toLong(2)
        return lifeSupportRating
    }

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198L)
    check(part2(testInput) == 230L)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}