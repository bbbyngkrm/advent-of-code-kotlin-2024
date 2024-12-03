fun main() {
    fun part1(inputs: List<String>): Int {
        return inputs
            .map { it.split(" ").map { it.toInt() } }
            .count { isSafe(it) }
    }

    fun part2(inputs: List<String>): Int {
        return inputs
            .map { it.split(" ").map { it.toInt() } }
            .count {
                if (isSafe(it)) {
                    return@count true
                } else {
                    it.forEachIndexed { index, _ ->
                        if (isSafe(it.toMutableList().apply { removeAt(index) }))
                            return@count true
                    }
                    return@count false
                }
            }
    }

    // Read the input from the `src/Day02.txt` file.
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}

fun isSafe(inputs: List<Int>): Boolean {
    val result = inputs.windowed(2).map { it[1] - it[0] }
    val increasing = result.all { it in 1..3 }
    val decreasing = result.all { it in -1 downTo -3 }
    return increasing || decreasing
}
