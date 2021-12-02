fun main() {
    val input = readInputToString("Day02")
    multipliedPosition(input)
    calculatePositionWithAim(input)
}

fun multipliedPosition(input: List<String>) {
    var horizontal = 0
    var vertical = 0
    input.forEach {
        val (command, value) = it.split(" ")
        when (command) {
            "forward" -> horizontal += value.toInt()
            "up" -> vertical -= value.toInt()
            "down" -> vertical += value.toInt()
        }
    }
    val multiplied = horizontal * vertical
    println("Horizontal position: $horizontal. Vertical position: $vertical")
    println("Multiplied: $multiplied")
}

fun calculatePositionWithAim(input: List<String>) {
    var horizontal = 0
    var vertical = 0
    var aim = 0
    input.forEach {
        val (command, value) = it.split(" ")
        when (command) {
            "forward" -> {
                horizontal += value.toInt()
                vertical += aim * value.toInt()
            }
            "up" -> aim -= value.toInt()
            "down" -> aim += value.toInt()
        }
    }
    val multiplied = horizontal * vertical
    println("Horizontal position: $horizontal. Vertical: $vertical")
    println("Multiplied: $multiplied")
}