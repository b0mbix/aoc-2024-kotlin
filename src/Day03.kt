import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val text = input.joinToString(separator = "")
        val regex = "mul\\((\\d+),(\\d+)\\)".toRegex()

        return regex.findAll(text).sumOf{
            val (a, b) = it.destructured
            a.toInt() * b.toInt()
        }
    }

    fun part2(input: List<String>): Int {
        val text = input.joinToString(separator = "")
        val regex = "mul\\((\\d+),(\\d+)\\)".toRegex()
        val regex_do = "do\\(\\)".toRegex()
        val regex_dont = "don't\\(\\)".toRegex()

        val checkedText1 = regex_dont.split(text)[0]
        val checkedText2 = regex_dont.split(text).drop(1).map{
            regex_do.split(it).drop(1)
        }.joinToString(separator = "")
        val checkedText = checkedText1 + checkedText2
        return regex.findAll(checkedText).sumOf{
            val (a, b) = it.destructured
            a.toInt() * b.toInt()
        }
    }

    // Read a test input from the `src/Day03_test.txt` file:
    val testInput1 = readInput("Day03_test")
    check(part1(testInput1) == 161)
    val testInput2 = readInput("Day03_test2")
    check(part2(testInput2) == 48)

    // Read the input from the `src/Day03.txt` file.
    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}
