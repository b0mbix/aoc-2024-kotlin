fun main() {
    fun part1(input: List<String>): Int {
        val xLength = input[0].length
        val yLength = input.size

        var count = 0
        for (i in 0..<yLength) {
            for (j in 0..<xLength) {
                if (input[i][j] == 'X') {
                    if (i >= 3) {
                        if (input[i-1][j] == 'M' && input[i-2][j] == 'A' && input[i-3][j] == 'S')
                            count++
                        if (j >= 3 && input[i-1][j-1] == 'M' && input[i-2][j-2] == 'A' && input[i-3][j-3] == 'S')
                            count++
                        if (j <= xLength - 4 && input[i-1][j+1] == 'M' && input[i-2][j+2] == 'A' && input[i-3][j+3] == 'S')
                            count++
                    }
                    if (i <= yLength - 4) {
                        if (input[i+1][j] == 'M' && input[i+2][j] == 'A' && input[i+3][j] == 'S')
                            count++
                        if (j >= 3 && input[i+1][j-1] == 'M' && input[i+2][j-2] == 'A' && input[i+3][j-3] == 'S')
                            count++
                        if (j <= xLength - 4 && input[i+1][j+1] == 'M' && input[i+2][j+2] == 'A' && input[i+3][j+3] == 'S')
                            count++
                    }
                    if (j >= 3 && input[i][j-1] == 'M' && input[i][j-2] == 'A' && input[i][j-3] == 'S')
                        count++
                    if (j <= xLength - 4 && input[i][j+1] == 'M' && input[i][j+2] == 'A' && input[i][j+3] == 'S')
                        count++
                }
            }
        }
        return count
    }

    fun part2(input: List<String>): Int {
        val xLength = input[0].length
        val yLength = input.size

        var count = 0
        for (i in 1..yLength-2) {
            for (j in 1..xLength-2) {
                if (input[i][j] == 'A') {
                    if (input[i-1][j-1] == 'M' && input[i-1][j+1] == 'M' && input[i+1][j-1] == 'S' && input[i+1][j+1] == 'S')
                        count++
                    if (input[i-1][j-1] == 'M' && input[i+1][j-1] == 'M' && input[i-1][j+1] == 'S' && input[i+1][j+1] == 'S')
                        count++
                    if (input[i-1][j-1] == 'S' && input[i-1][j+1] == 'S' && input[i+1][j-1] == 'M' && input[i+1][j+1] == 'M')
                        count++
                    if (input[i-1][j-1] == 'S' && input[i+1][j-1] == 'S' && input[i-1][j+1] == 'M' && input[i+1][j+1] == 'M')
                        count++
                }
            }
        }
        return count
    }

    // Read a test input from the `src/Day04_test.txt` file:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 18)
    check(part2(testInput) == 9)

    // Read the input from the `src/Day04.txt` file.
    val input = readInput("Day04")
    part1(input).println()
    part2(input).println()
}
