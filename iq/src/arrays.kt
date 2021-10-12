import java.util.*

fun main() {
    val arr = arrayOf("geezer", "geeksforgeeks", "geeks", "geek")
    println("Longest prefix: " + longestPrefix(arr))
}

// Given a set of strings, find the longest common prefix.
fun longestPrefix(arr: Array<String>): String {
    println("Unsorted: " + Arrays.toString(arr))
    arr.sort()
    println("Sorted: " + Arrays.toString(arr))

    // Starting position is the length of the shortest string.
    var pos = arr[0].length

    for (i in arr.indices) {
        if (arr[i].elementAt(pos) != arr[i + 1].elementAt(pos))
            break
        pos--
    }

    return "Longest prefix: " + arr[0].substring(0, pos)
}