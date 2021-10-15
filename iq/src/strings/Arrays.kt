package strings

class Arrays {
    // Given array of integers write a function to move all zero values to the end of the list.
    // Given [0,2,4,0,6,0] return [2,4,6,0,0,0]
    fun moveZerosToEnd(arr: MutableList<Int>): MutableList<Int> {
        // Keep two indexes.
        var i = 0   // Points to element with 0 value.
        var j = 0   // Points to element with non-0 value.

        while (i < arr.size) {
            if (arr[i] == 0) {
                i++
            }
            else {
                arr[j++] = arr[i]
                arr[i++] = 0
            }
        }

        return arr
    }

    // Given array of integers write a function to move all zero values to the beginning of the list.
    // Given [0,2,4,0,6,0] return [0,0,0,2,4,6]
    fun moveZerosToBegining(arr: MutableList<Int>):MutableList<Int> {
        var i = arr.size - 1; // Points to element with 0 value.
        var j = arr.size - 1; // Points to element with non-0 value.

        while (i >= 0) {
            if (arr[i] == 0) {
                i--
            }
            else {
                arr[j--] = arr[i]
                arr[i--] = 0
            }
        }

        return arr
    }
}

fun main() {
    var numbers = mutableListOf(0,2,4,0,6,0)

    println("Array before: " + numbers.toString())
    println("Array after: " + Arrays().moveZerosToEnd(numbers).toString())
    println("Array after: " + Arrays().moveZerosToBegining(numbers).toString())
}