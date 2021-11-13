package sort

/*
 * Follows divide and conquer paradigm.
 */
class MergeSort {
}

fun main() {
    var list = listOf<Int>(5,2,4,7,1,3,2,6)
    println("Unsorted list $list")
    mergeSort(list)
    println("Sorted list $list")
}

fun mergeSort(list: List<Int>): List<Int> {
    if (list.size == 1) return list

    val middle = list.size/2
    val left = list.subList(0, middle)
    val right = list.subList(middle + 1, list.size)

    return merge(mergeSort(left), mergeSort(right))
}

fun merge(left: List<Int>, right: List<Int>): List<Int> {
    var indexLeft = 0
    var indexRight = 0
    var sublist = mutableListOf<Int>()

    
}