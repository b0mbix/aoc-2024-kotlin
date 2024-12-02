fun main() {
    fun part1(input: List<String>): Int {
        val numbers: List<List<Int>> = input.map{
            line -> line.split(" ").map {
                it.toInt()
            }
        }
        return numbers.count{ levels ->
            val sorted = levels.sorted()
            val diffCond: Boolean = sorted.zipWithNext().all{ it.second - it.first in 1..3 }
            (sorted == levels || sorted.reversed() == levels) && diffCond
        }
    }

    fun part2(input: List<String>): Int {
        val numbers: List<List<Int>> = input.map { line ->
            line.split(" ").map {
                it.toInt()
            }
        }
        return numbers.count{ levels ->
            val options: MutableList<List<Int>> = mutableListOf()
            options.add(levels)
            for (deleted in levels.indices) {
                options.add(levels.filterIndexed{ i, _ -> i != deleted })
            }
            options.any{ levelsModified ->
                val sorted = levelsModified.sorted()
                val diffCond: Boolean = sorted.zipWithNext().all{ it.second - it.first in 1..3 }
                (sorted == levelsModified || sorted.reversed() == levelsModified) && diffCond
            }
        }
    }

    // Read a test input from the `src/Day02_test.txt` file:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    // Read the input from the `src/Day02.txt` file.
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
