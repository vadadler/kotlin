package strings

class Reverse {
    fun reverseString(str: String): String {
        var start = 0
        var end = str.length - 1

        var ch1: Char
        var ch2: Char
        var chars = str.toCharArray()

        while (start < end) {
            ch1 = str.elementAt(start)
            ch2 = str.elementAt(end)

            chars[start] = ch2
            chars[end] = ch1

            start++
            end--
        }

        return String(chars)
    }
}

fun main() {
    var str1 = "morning"
    var str2 = "moon"

    println("Original: $str1 Reversed: " + Reverse().reverseString(str1))
    println("Original: $str2 Reversed: " + Reverse().reverseString(str2))
}

