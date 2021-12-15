package days

import readInput

fun main() {
    fun mapCoordinates(x1: Int, y1: Int, map: MutableMap<Pair<Int, Int>, Int>) {
        if (map[x1 to y1] == null) {
            map[x1 to y1] = 1
        } else map[x1 to y1] = map.getValue(x1 to y1) + 1
    }

    fun part1(input: List<String>): Int {
        val map: MutableMap<Pair<Int, Int>, Int> = mutableMapOf()
        input.forEach { it ->
            val (x1y1, x2y2) = it.split(" -> ")
            var (x1, y1) = x1y1.split(",").map { it.toInt() }
            val (x2, y2) = x2y2.split(",").map { it.toInt() }
            if (x1 != x2 && y1 != y2) return@forEach
            if (x1 < x2) {
                while (x1 <= x2) {
                    mapCoordinates(x1, y1, map)
                    x1++
                }
            } else if (y1 < y2) {
                while (y1 <= y2) {
                    mapCoordinates(x1, y1, map)
                    y1++
                }
            } else if (x1 > x2) {
                while (x1 >= x2) {
                    mapCoordinates(x1, y1, map)
                    x1--
                }
            } else if (y1 > y2) {
                while (y1 >= y2) {
                    mapCoordinates(x1, y1, map)
                    y1--
                }
            }
        }
        val filteredMap = map.filterValues { it >= 2 }
        return filteredMap.size
    }

    fun part2(input: List<String>): Int {
        var map: MutableMap<Pair<Int, Int>, Int> = mutableMapOf()
        input.forEach { it ->
            val (x1y1, x2y2) = it.split(" -> ")
            var (x1, y1) = x1y1.split(",").map { it.toInt() }
            val (x2, y2) = x2y2.split(",").map { it.toInt() }
            if (x1 < x2 && y1 == y2) {
                while (x1 <= x2) {
                    mapCoordinates(x1, y1, map)
                    x1++
                }
            } else if (y1 < y2 && x1 == x2) {
                while (y1 <= y2) {
                    mapCoordinates(x1, y1, map)
                    y1++
                }
            } else if (x1 > x2 && y1 == y2) {
                while (x1 >= x2) {
                    mapCoordinates(x1, y1, map)
                    x1--
                }
            } else if (y1 > y2 && x1 == x2) {
                while (y1 >= y2) {
                    mapCoordinates(x1, y1, map)
                    y1--
                }
            } else if (y1 > y2 && x1 > x2) {
                while (y1 >= y2 && x1 >= x2) {
                    mapCoordinates(x1, y1, map)
                    y1--
                    x1--
                }
            } else if (y1 > y2 && x1 < x2) {
                while (y1 >= y2 && x1 <= x2) {
                    mapCoordinates(x1, y1, map)
                    y1--
                    x1++
                }
            } else if (y1 < y2 && x1 < x2) {
                while (y1 <= y2 && x1 <= x2) {
                    mapCoordinates(x1, y1, map)
                    y1++
                    x1++
                }
            } else if (y1 < y2 && x1 > x2) {
                while (y1 <= y2 && x1 >= x2) {
                    mapCoordinates(x1, y1, map)
                    y1++
                    x1--
                }
            }
        }
        val filteredMap = map.filterValues { it >= 2 }
        return filteredMap.size
    }

    val testInput = readInput("Day05_test")
    check(part1(testInput) == 5)
    check(part2(testInput) == 12)

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}