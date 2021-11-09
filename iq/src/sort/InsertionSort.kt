package sort

/*
 * Time complexity O(n^2). Space complexity O(1).
 */
class InsertionSort {
}

fun main() {
    var list = mutableListOf<Int>(5,2,4,6,1,3)

    println("Unsorted list $list")
    insertionSort(list)
    println("Sorted list $list")
    insertionSortReverse(list)
    println("Resorted list $list")
}

fun insertionSort(list: MutableList<Int>) {
    for (i in 1..list.size - 1) {
        var v1 = list[i]
        var j = i - 1

        while (j >= 0 && v1 < list[j]) {
            val v2 = list[j + 1]
            list[j+1] = list[j]
            list[j] = v2
            j -= 1
        }
    }
}

// Sort from largest to smallest.
fun insertionSortReverse(list: MutableList<Int>) {
    for(i in 1..list.size - 1) {
        var v = list[i]
        var j = i - 1
        while (j >= 0 && list[j] < v) {
            var v2 = list[j]
            list[j] = list[j + 1]
            list[j + 1] = v2
            j -= 1
        }
    }
}