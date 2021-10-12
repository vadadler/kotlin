import java.lang.StringBuilder

fun main() {
    val str1 = "Hello, "
    val str2 = "World!"

    println(concatPlusOperator(str1, str2))
    println(concatPlusFunction(str1, str2))
    println(concatTemplate(str1, str2))
    println(concatStringBuilder(str1, str2))
}

// Sting concatenation.

//+ or plus() reatec a new instance of String object. Don't use it.
fun concatPlusOperator(s1: String, s2: String): String {
    return s1 + s2
}

fun concatPlusFunction(s1: String, s2: String): String {
    return s1.plus(s2)
}

// Preferred ways: use templates or StringBuilder.
fun concatTemplate(s1: String, s2: String): String {
    return "$s1$s2"
}

fun concatStringBuilder(s1: String, s2: String): String {
    var sb = StringBuilder()
    return sb.append(s1).append(s2).toString()
}

