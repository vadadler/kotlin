package strings

class Arrays {
    // Given array of integers write a function to move all zero values to the end of the list.
    // Given [0,2,4,0,6,0] return [2,4,6,0,0,0]

    fun moveZerosToEnd(arr: MutableList<Int>): MutableList<Int> {
        var i = 0
        var j = 0

        while (i < arr.size) {
            if (arr.elementAt(i) == 0) {
                i++
            }
            else {
                arr[j++] = arr[i]
                arr[i++] = 0
            }
        }

        return arr
    }
}

fun main() {
    var numbers = mutableListOf(0,2,4,0,6,0)

    println("Array before: " + numbers.toString())
    println("Array after: " + Arrays().moveZerosToEnd(numbers).toString())
}