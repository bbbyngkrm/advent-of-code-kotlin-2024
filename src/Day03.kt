fun main() {
    fun part1(inputs: List<String>): Int {
        return Regex("mul\\([0-9]+,[0-9]+\\)")
            .findAll(inputs.joinToString())
            .map { it.value.substring(4, it.value.length - 1).split(",") }
            .sumOf { it[0].toInt() * it[1].toInt() }
    }

    fun part2(inputs: List<String>): Int {
        var sum = 0
        var add = true
        Regex("mul\\([0-9]+,[0-9]+\\)|do\\(\\)|don't\\(\\)")
            .findAll(inputs.joinToString())
            .map {
                if (it.value.startsWith("mul")) {
                    it.value.substring(4, it.value.length - 1)
                } else {
                    it.value
                }
            }
            .forEach {
                when (it) {
                    "do()" -> {
                        add = true
                    }
                    "don't()" -> {
                        add = false
                    }
                    else -> {
                        val n = it.split(",").map { it.toInt() }
                        if (add) sum += (n[0] * n[1])
                    }
                }
            }
        return sum
    }

    // Read the input from the `src/Day00.txt` file.
    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}
