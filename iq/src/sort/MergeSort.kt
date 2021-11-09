package sort

/*
 * Follows divide and conquer paradigm.
 */
class MergeSort {
}

fun main() {
    var list = listOf<Int>(5,2,4,7,1,3,2,6)
    println("Unsorted list $list")
    mergeSort(list, 0, list.size / 2)
    println("Sorted list $list")
}

fun mergeSort(list: List<Int>, l: Int, r: Int) {
    if (l < r) {
        val left = list.subList(0, l)
        val right = list.subList(l + 1, list.size)

        mergeSort(left, 0, left.size/2)
        mergeSort(right, 0, left.size/2)
        merge(MutableList<Int>(left.size + right.size,{0}), left, right)
    }
}

fun merge(list: MutableList<Int>, left: List<Int>, right: List<Int>) {
    
}