import kotlin.math.abs

fun main() {
    fun part1(inputs: List<String>): Int {
        val lefts = arrayListOf<Int>()
        val rights = arrayListOf<Int>()
        inputs.map { input ->
            lefts.add(input.split("   ").first().toInt())
            rights.add(input.split("   ").last().toInt())
        }
        lefts.sort()
        rights.sort()
        var sum = 0
        lefts.forEachIndexed { index, left ->
            sum += abs(left - rights[index])
        }
        return sum
    }

    fun part2(inputs: List<String>): Int {
        val lefts = arrayListOf<Int>()
        val rights = arrayListOf<Int>()
        inputs.map { input ->
            lefts.add(input.split("   ").first().toInt())
            rights.add(input.split("   ").last().toInt())
        }
        var sum = 0
        lefts.forEach { left ->
            sum += abs(left * rights.filter { it == left }.size)
        }
        return sum
    }

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
