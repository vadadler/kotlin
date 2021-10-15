package strings

import java.util.*

class LongestPrefix {
    // Given a set of strings, find the longest common prefix.
    // Algorithm assumes, that after sorting the shortest string is the first one.
    fun longestPrefix(arr: Array<String>): String {
        println("Unsorted: " + java.util.Arrays.toString(arr))
        arr.sort()
        println("Sorted: " + java.util.Arrays.toString(arr))

        // Starting position is the length of the shortest string.
        var pos = arr[0].length - 1
        var isFoundMismatch = false

        while (pos >= 0) {
            for (i in arr.indices) {
                if (arr[i].elementAt(pos) != arr[i + 1].elementAt(pos)) {
                    isFoundMismatch = true
                    break
                }
            }

            if (isFoundMismatch == true) {
                break
            }

            pos--
        }

        return "Longest prefix: " + arr[0].substring(0, pos)
    }
}

fun main() {
    val arr = arrayOf("geezer", "geeksforgeeks", "geeks", "geek")
    println("Longest prefix: " + LongestPrefix().longestPrefix(arr))
}