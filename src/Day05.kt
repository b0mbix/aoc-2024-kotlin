fun main() {
    fun checkPrint(nums: List<Int>, beforeValues: List<MutableSet<Int>>): Int {
        val forbidden: MutableSet<Int> = mutableSetOf()
        for (num in nums) {
            if (num in forbidden) {
                return 0
            }
            forbidden.addAll(beforeValues[num])
        }
        return nums[nums.size/2]
    }

    fun part1(input: List<String>): Int {
        val sep = input.indexOf("")
        val rules = input.subList(0, sep)
        val prints = input.subList(sep+1, input.size)
        val beforeValues: List<MutableSet<Int>> = List(100) { mutableSetOf() }

        for (rule in rules) {
            val (num1, num2) = rule.split("|").map { it.toInt() }
            beforeValues[num2].add(num1)
        }
        return prints.sumOf { line ->
            checkPrint(line.split(',').map { it.toInt() }, beforeValues)
        }
    }

    fun fixPrint(nums: List<Int>, beforeValues: List<MutableSet<Int>>): Int {
        val mutableNums = nums.toMutableList()
        var fixed = true
        for (i in nums.size-1 downTo 0) {
            for (j in i-1 downTo 0) {
                if (mutableNums[i] in beforeValues[mutableNums[j]]) {
                    val temp = mutableNums[i]
                    mutableNums[i] = mutableNums[j]
                    mutableNums[j] = temp
                    fixed = false
                }
            }
        }
        return if (!fixed) mutableNums[nums.size / 2] else 0
    }

    fun part2(input: List<String>): Int {
        val sep = input.indexOf("")
        val rules = input.subList(0, sep)
        val prints = input.subList(sep+1, input.size)
        val beforeValues: List<MutableSet<Int>> = List(100) { mutableSetOf() }

        for (rule in rules) {
            val (num1, num2) = rule.split("|").map { it.toInt() }
            beforeValues[num2].add(num1)
        }
        return prints.sumOf { line ->
            fixPrint(line.split(',').map { it.toInt() }, beforeValues)
        }
    }

    // Read a test input from the `src/Day05_test.txt` file:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == 143)
    check(part2(testInput) == 123)

    // Read the input from the `src/Day05.txt` file.
    val input = readInput("Day05")
    part1(input).println()
    part2(input).println()
}
