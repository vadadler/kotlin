package sort

/*
 * Follows divide and conquer paradigm.
 */
class MergeSort {
}

fun main() {
    var list = listOf<Int>(5,2,4,7,1,3,2,6)
    println("Unsorted list $list")
    var sortedList = mergeSort(list)
    println("Sorted list $sortedList")
}

fun mergeSort(list: List<Int>): List<Int> {
    if (list.size == 1) return list

    val middle = list.size/2
    val left = list.subList(0, middle)
    val right = list.subList(middle, list.size)

    return merge(mergeSort(left), mergeSort(right))
}

fun merge(left: List<Int>, right: List<Int>): List<Int> {
    var indexLeft = 0
    var indexRight = 0
    var tempList = mutableListOf<Int>()

    while (indexLeft < left.size && indexRight < right.size) {
        if (left[indexLeft] > right[indexRight]) {
            tempList.add(right[indexRight++])
        }
        else {
            tempList.add(left[indexLeft++])
        }
    }

    while (indexLeft < left.size) {
        tempList.add(left[indexLeft++])
    }

    while (indexRight < right.size) {
        tempList.add(right[indexRight++])
    }

    return tempList
}