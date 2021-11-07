package sort

class InsertionSort {
}

fun main() {
    var list = mutableListOf<Int>(5,2,4,6,1,3)

    println("Unsorted list $list")
    insertionSort(list)
    println("Sorted list $list")
}

fun insertionSort(list: MutableList<Int>) {
    for (i in 1..list.size - 1) {
        var v = list[i]
        var j = i - 1
        while (j >= 0 && v < list[j]) {
            list[i] = list[j]
            list[j--] = v
        }
    }
}