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

}

fun main() {
    var arr = mutableListOf<Int>(0,2,1,0,6,0)
    println("Array before: $arr")
    moveZerosToBack(arr)
    println("Array after: $arr")
//    print("Array after 2: ${moveZerosToFront(arr)}")
}

