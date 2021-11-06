package co

class Meta {
}

fun main() {
    val listSorted = listOf(1,3,7,9,10)
    val listUnsorted = listOf(3,1,2,4,7,6)
    val listUnsorted2 = listOf(3,1,9,4,7,2)
    val sum = 8
    //var ret = twoNumSum(listSorted, sum)
//    if (ret.size == 0) println("No two elements in $list add to $sum")
//    else println("In array $list elements ${list.get(ret.get(0))}+${list.get(ret.get(1))}=$sum")

    var ret2 = twoNumSumUnsorted(listUnsorted2, sum)
}

// Given a sorted array, find 2 numbers that sum up to S.
fun twoNumSum(list: List<Int>, sum: Int): List<Int> {
    var ret = mutableListOf<Int>()
    var beg = 0
    var end = list.size - 1

    while (beg < end) {
        var s = list[beg] + list[end]
        if ( s < sum) {
            beg += 1
        }
        else if (s > sum) {
            end -= 1
        }
        else if (s == sum) {
            ret.add(beg)
            ret.add(end)
            break
        }
        else {

        }
    }
    return ret
}

// Given an unsorted array, find 2 numbers that sum up to S.
// THE STRATEGY BELOW DOES NOT WORK!
// The strategy here is to walk input list, for each pair of numbers sum them up and subtruct desired sum and store
// result in a set. Walk that set and see if value of 0 is there or two values add to 0. If that's the case, then
// there are two numbers which sum is the desired one.
fun twoNumSumUnsorted(list: List<Int>, sum: Int): List<Int> {
    var ret = mutableListOf<Int>()
    var resultsSet = mutableSetOf<Int>()
    var resultsMap = mutableMapOf<String, Int>()

    for (i in 0..list.size - 2) {
        var value = list[i] + list[i + 1] - sum
        resultsSet.add(value)
        resultsMap.put("$i", value)
    }

    for (i in 0..resultsSet.size - 2) {
        if (resultsSet.elementAt(i) + resultsSet.elementAt(i + 1) == 0 ) {

        }
    }
    return ret
}
