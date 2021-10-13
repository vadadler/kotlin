package strings

class Tutti {
}
fun main() {
//    println("sum of 0 = " + sum1toN(0))
//    println("sum of 1 = " + sum1toN(1))
//    println("sum of 5 = " + sum1toN(5))
//    println("Recursive solution:")
//    println("sum of 5 = " + sum1toNR(5))
//    println("sum of 0 = " + sum1toNR(0))
//    println("sum of 1 = " + sum1toNR(1))

    val s1 = "listen"
    val s2 = "silent"
    println("Strings $s1 and $s2 are anagram? " + isAnagram("listen", "silent"))
}

// Return sum of N numbers. For example: sum1toN(5) = 1+2+3+4+5
fun sum1toN(num: Int): Int {
    var sum = 0
    var i = 0

    while(i <= num) {
        sum += i++
    }

    return sum
}

// Return sum of N numbers with recursively. For example: sum1toNR(5) = 1+2+3+4+5
fun sum1toNR(num: Int): Int {
    var sum = 0
    if(num == 1) return 1
    if(num == 0) return 0

    return num + sum1toNR(num-1)
}



// Check whether two Strings are Anagram of each other.

// Solution 1: convert strings to CharArray, sort them and compare.
// Alternatively String.toHashSet() can be used.
fun isAnagram(str1: String, str2: String): Boolean {
    var chArr1 = str1.toCharArray().sorted()
    var chArr2 = str2.toCharArray().sorted()

    var hSet1 = str1.toHashSet().sorted()
    var hSet2 = str2.toHashSet().sorted()

    //return chArr1 == chArr2
    return hSet1 == hSet2
}
