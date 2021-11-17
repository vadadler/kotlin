package arrays

class MoveZeros {

}

fun moveZerosToBack(arr: MutableList<Int>) {
    // Keep two indexes. One pointing to element with 0 and the other !0 element.
    var i = 0 // 0 element.
    var j = 0 // where to place !0 element.

    while (i < arr.size - 1) {
        if (arr[i] != 0) {
            arr[j] = arr[i]
            i++
            j++
        }
        else {
            i++
        }
    }

    while (j < arr.size - 1) arr[j++] = 0
}

fun moveZerosToFront(arr: MutableList<Int>) {
    var i = arr.size - 1 // tracks 0 element.
    var j = arr.size - 1 // where to plase !0 element.

    while (i >= 0) {
        if (arr[i] == 0) {
            i--
        }
        else {
            arr[j--] = arr[i--]
        }
    }

    while (j >= 0) arr[j--] = 0
}

fun main() {
    var arr = mutableListOf<Int>(0,2,1,0,6,0)
    println("Array before: $arr")
    moveZerosToBack(arr)
    println("Array after to back: $arr")
    moveZerosToFront(arr)
    print("Array after to front: $arr")
}

