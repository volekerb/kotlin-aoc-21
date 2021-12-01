fun main() {
    fun countDepthTimes(input: List<Int>): Int {
        return input.windowed(2).count { (left, right) -> right > left }
    }

    fun countWindowedSumDepths(input: List<Int>): Int {
        return input.windowed(3) {it.sum()}.windowed(2).count { (curr, next) -> next > curr }
    }

    val input = readInput("Day01")
    println(countDepthTimes(input))
    println(countWindowedSumDepths(input))
}
