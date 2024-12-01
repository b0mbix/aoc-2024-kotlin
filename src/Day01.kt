import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val numbers: List<List<Int>> = input.map{
            line -> line.split("   ").map{
                it.toInt()
            }
        }
        val list1 = numbers.map{ it[0] }.sorted()
        val list2 = numbers.map{ it[1] }.sorted()
        var sum = 0
        list1.zip(list2).forEach{
            pair -> sum += abs(pair.first - pair.second)
        }

        return sum
    }

    fun part2(input: List<String>): Int {
        val numbers: List<List<Int>> = input.map{
            line -> line.split("   ").map{
                it.toInt()
            }
        }
        val list1 = numbers.map{ it[0] }.sorted()
        val list2 = numbers.map{ it[1] }.sorted()

        val counts = list2.groupingBy{ it }.eachCount()
        var sum = 0
        list1.forEach{
            sum += it * (counts[it] ?: 0)
        }

        return sum
    }

    // Read a test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
