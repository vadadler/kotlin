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

    
    return "Longest prefix: "
}