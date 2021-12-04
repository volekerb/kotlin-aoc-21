fun main() {
    val input = readInputToString("Day03")

    val zeros = Array(input[0].length) { 0 }
    val ones = Array(input[0].length) { 0 }
    input.forEach {
        it.forEachIndexed { index, c ->
            when (c) {
                '0' -> zeros[index]++
                '1' -> ones[index]++
            }
        }
    }
    val calculateGammaEpsilon = calculateGammaEpsilon(zeros, ones)
    println(calculateGammaEpsilon.first.toInt(2) * calculateGammaEpsilon.second.toInt(2))

    val oxygenAndCo2 = getOxygenAndCo2(input)
    println(oxygenAndCo2.first.toInt(2) * oxygenAndCo2.second.toInt(2))
}

fun calculateGammaEpsilon(zeros: Array<Int>, ones: Array<Int>): Pair<String, String> {
    var gamma = ""
    var epsilon = ""
    zeros.forEachIndexed { index, i ->
        if (i > ones[index]) {
            gamma += "0"
            epsilon += "1"
        } else {
            gamma += "1"
            epsilon += "0"
        }
    }
    return Pair(gamma, epsilon)
}

fun getListOfNumbersToReturn(
    listOfNumbers: MutableList<String>,
    indexToLookAt: Int,
    charToLookFor: Char
): MutableList<String> {
    if (listOfNumbers.size == 1) return listOfNumbers
    val listOfNumbersToReturn = mutableListOf<String>()
    listOfNumbers.forEach { s ->
        if (s[indexToLookAt] == charToLookFor) {
            listOfNumbersToReturn.add(s)
        }
    }
    return listOfNumbersToReturn
}

fun getOxygenAndCo2(listOfNumbers: List<String>): Pair<String, String> {
    var oxygenList = listOfNumbers.toMutableList()
    var co2List = listOfNumbers.toMutableList()
    for (i in 0 until oxygenList[0].length) {
        var zerosO = 0
        var zerosCO2 = 0
        var onesO = 0
        var onesCO2 = 0
        oxygenList.forEach {
            if (it[i] == '0') zerosO++ else onesO++
        }
        co2List.forEach {
            if (it[i] == '0') zerosCO2++ else onesCO2++
        }
        oxygenList = getListOfNumbersToReturn(oxygenList, i, if (zerosO > onesO) '0' else '1')
        co2List = getListOfNumbersToReturn(co2List, i, if (zerosCO2 > onesCO2) '1' else '0')
    }
    return Pair(oxygenList[0], co2List[0])
}
