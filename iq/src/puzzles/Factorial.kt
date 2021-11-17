package puzzles

class Factorial {
}

fun main() {
    var arr = mutableListOf<Int>(1,2,3,4,5)
    for(i in 0..arr.size) {

    }
    val num = 5
    println("Factorial, loop implementation, of $num = ${factorialLoop(num)}")
    println("Factorial, recursive implementation, of $num = ${factorialRecursive(num)}")
}

fun factorialLoop(num: Int): Int {
    if (num == 0) return 0

    var ret = 1

    for(i in 1..num) {
        ret *= i
    }

    return ret
}

fun factorialRecursive(num: Int): Int {
    if (num == 1) return 1
    return num * factorialRecursive(num - 1)
}
