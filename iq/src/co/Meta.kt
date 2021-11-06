package co

class Meta {
}

fun main() {
    val list = listOf(1,3,7,9,10)
    val sum = 12
    val ret = twoNumSum(list, sum)
    if (ret.size == 0) println("No two elements in $list add to $sum")
    else println("In array $list elements ${list.get(ret.get(0))}+${list.get(ret.get(1))}=$sum")
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
// The strategy here is to walk input list, for each pair of numbers sum them up and subtruct desired sum and store
// result in a set. Walk that set and see if value of 0 is there or two values add to 0. If that's the case, then
// there are two numbers which sum is the desired one. 
fun twoNumSumUnsorted(list: List<Int>, sum: Int): List<Int> {
    var ret = mutableListOf<Int>()
    return ret
}
