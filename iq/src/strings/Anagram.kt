package strings

/*
An anagram of a string is another string that contains the same characters, only the order of characters can be
different. For example, “abcd” and “dabc” are an anagram of each other.
 */
class Anagram {
    fun isAnagramSorted(s1: String, s2: String): Boolean {
        return  s1.toSortedSet().toString().equals(s2.toSortedSet().toString())
    }
}

fun main() {
    val s1 = "abcd"
    val s2 = "bdac"
    println("Is $s1 anagram of $s2? ${Anagram().isAnagramSorted(s1, s2)}")
}