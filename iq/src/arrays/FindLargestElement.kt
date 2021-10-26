package arrays

/*
 * In an array of integers find the largest element.
 */
class FindLargestElement {
    fun findLargestLoop(list: List<Int>): Int {
        var largestElement = 0

        for (i in list.indices) {
            if (list[i] > largestElement) {
                largestElement = list[i]
            }
        }
        return largestElement
    }

    fun findLargestRecursive(list: List<Int>, i: Int, max: Int): Int {
        if (i == list.size - 1) {
            return max
        }

        var tmp = max
        if (list[i] > max) {
            tmp = list[i]
        }

        return findLargestRecursive(list, i + 1, tmp)
    }
}

fun main() {
    val list = listOf(1,5,300,7,8,21,6,72)

    println("The largest element in $list is ${FindLargestElement().findLargestLoop(list)}")
    println("The largest element in $list is ${FindLargestElement().findLargestRecursive(list, 0, 0)}")
}