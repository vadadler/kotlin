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
}

fun main() {
    val list = listOf(1,5,300,7,8,21,6,72)

    println("The largest element in $list is ${FindLargestElement().findLargestLoop(list)}")
}