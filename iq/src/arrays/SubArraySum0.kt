package arrays

/**
 * Given an array of positive and negative numbers, find if there is a
 * subarray (of size at-least one) with 0 sum.
 *
 */
class SubArraySum0 {
    /*
     * Brute force O(n^2) time complexity walk. Two loops: outer running from i and inner running from i+1 searching
     * for subarray with sum of 0.
     */
    fun isSubarrayLoops(list: List<Int>): Boolean {
        var sum = 0
        for (i in list.indices) {
            sum = list[i]
            if (sum == 0) {
                return true
            }

            val sublist = list.subList(i + 1, list.size)
            for (j in sublist.indices) {
                sum += sublist[j]
                if (sum == 0) {
                    return true
                }
            }
        }
        return false
    }

    /*
     * Use a MutableSet<Int> to store sums for each element list[i] calculated as sum of list elements from 0 to i.
     * If a sum already exists in the set then there is a subarray with sum of 0. Complexity is O(n).
     */
    fun isSubarraySet(list: List<Int>): Boolean {
        var sumSet = mutableSetOf<Int>()

        var sum = 0
        for (i in list.indices) {
            sum += list[i]
            if (sumSet.contains(sum)) {
                return true
            }
            sumSet.add(sum)
        }

        return false
    }
}

fun main() {
    val arr = listOf(2, 5,-3, -3, 6, -5, 4)

    println("Brute force: Is there a subarray for $arr ${SubArraySum0().isSubarrayLoops(arr)}" )
    println("Using set: Is there a subarray for $arr ${SubArraySum0().isSubarraySet(arr)}" )
}