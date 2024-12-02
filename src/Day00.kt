fun main() {
    fun part1(inputs: List<String>): Int {
        return inputs.size
    }

    fun part2(inputs: List<String>): Int {
        return inputs.size
    }

    // Test if implementation meets criteria from the description, like:
    check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day00_test")
    check(part1(testInput) == 1)

    // Read the input from the `src/Day00.txt` file.
    val input = readInput("Day00")
    part1(input).println()
    part2(input).println()
}
