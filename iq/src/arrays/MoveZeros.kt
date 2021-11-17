package arrays

class MoveZeros {

}

fun moveZerosToBack(arr: MutableList<Int>) {
    // Keep two indexes. One pointing to element with 0 and the other !0 element.
    var i = 0 // 0 element.
    var j = 0 // !0 element.

    for (element in arr.indices ) {
        if (arr[element] != 0) {

        }
        else {

        }
    }
}

fun moveZerosToFront(arr: MutableList<Int>) {

}

fun main() {
    var arr = mutableListOf<Int>(0,2,1,0,6,0)
    print("Array before: $arr")
    print("Array after: ${moveZerosToBack(arr)}")
    print("Array after 2: ${moveZerosToFront(arr)}")
}

