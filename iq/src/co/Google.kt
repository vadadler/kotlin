package co

import java.util.*

class Meta {
}

fun main() {
    val listSorted = listOf(1,3,7,9,10)
    val listUnsorted = listOf(3,1,2,4,7,6)
//    val listUnsorted2 = listOf(3,1,9,4,7,2)
    val sum = 8
//    var ret = twoNumSum(listSorted, sum)
//    if (ret.size == 0) println("No two elements in $list add to $sum")
//    else println("In array $list elements ${list.get(ret.get(0))}+${list.get(ret.get(1))}=$sum")

    var ret = twoNumSumUnsorted(listUnsorted,8)
    if (ret.size == 0) println("No two elements in $listUnsorted add to $sum")
    else println("In array $listUnsorted elements ${listUnsorted.get(ret.get(0))}+${listUnsorted.get(ret.get(1))}=$sum")
}

/*
 * Given a sorted array, find 2 numbers that sum up to S.
 *
 * To solve this in O(N) time, we can keep two indices – one in the beginning
 * (start) and the other in the end (end). If the sum of the current two numbers
 * is greater than S, we move the end pointer backward by one step. If the sum
 * is smaller than S, we move the start pointer forward by one step.
 * When the two pointers meet each other, we know that no two numbers sum up to S.
 * The reason we can make it O(N) is that the array is sorted and we don’t need to
 * check all the combinations.
*/
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

// Given an unsorted array A, find 2 numbers that sum up to S.
// Strategy: walk the array and for each element store its compliment = (S - A[n]) in a set.
// When visiting an element check if its compliment exists in A. If it does, there
// are two numbers which add up to S.
fun twoNumSumUnsorted(list: List<Int>, sum: Int): List<Int> {
    var ret = mutableListOf<Int>()
    var resultsSet = mutableSetOf<Int>()
    var resultsMap = mutableMapOf<String, Int>()

    for (i in list.indices) {
        val compliment = sum - list[i]

        for (j in i + 1 until list.size) {
            if (list[j] == compliment) {
                ret.add(0, i)
                ret.add(1, j)
                return ret;
            }
        }
    }

    return ret
}

/**
 * Determine if any 3 integers in an array sum to S.
 * @param arr input array
 * @param sum sum
 *
 * Brute force approach. Make 3 nested loops and iterate through to find solution.
 * Time complexity O(N^3)
 */
private fun threeSumBruteForce(arr: IntArray, sum: Int) {
    println("Find sum=" + sum + " in array " + Arrays.toString(arr))
    val size = arr.size
    for (i in 0 until size) {
        for (j in i + 1 until size) {
            for (k in j + 1 until size) {
                val currSum = arr[i] + arr[j] + arr[k]
                if (currSum == sum) {
                    println("3sum found: " + arr[i] + "+" + arr[j] + "+" + arr[k] + "=" + sum)
                    return
                }
            }
        }
    }
    println("3sum not found: array " + Arrays.toString(arr) + " to find sum=" + sum)
}

