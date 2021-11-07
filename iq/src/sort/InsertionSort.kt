package sort

class InsertionSort {
}

fun main() {
    var list = mutableListOf<Int>(5,2,4,6,1,3)

    println("Unsorted list $list")
    insertionSortReverse(list)
    println("Sorted list $list")
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
        while (j >= 0 && list[j] < list[i]) {
            var v2 = list[j]
            list[j] = list[j + 1]
            list[j + 1] = v2
            j -= 1
        }
    }
}