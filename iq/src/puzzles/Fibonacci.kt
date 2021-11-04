package puzzles

import java.math.BigInteger

class Fibonacci {
}

fun main() {
    println(fibHashMap(0))
    println(fibHashMap(1))
    println(fibHashMap(2))
    println(fibHashMap(3))
    println(fibHashMap(4))
    println(fibHashMap(5))
    println(fibHashMap(6))
    println(fibHashMap(7))

//    val n = 1
//    println("Fib iterative fib($n) = ${fibHashMap(n)}")
//    println("Fib iterative fib($n) = ${fibIter(n)}")
//    println("Fib recursive $n = ${fibRecursive(n)}")
}

fun fibIter(num: Int): Int {
    if (num == 0) return 0
    if (num == 1 || num == 2) return 1

    var ret = 0;
    for (i in (num - 2) downTo 0) {
        ret += i
    }

    return ret + num - 1
}

fun fibHashMap(num: Int): Int {
    if (num == 0) return 0
    if (num == 1 || num == 2) return 1

    var vals = HashMap<Int, Int>()
    for (i in 0..num - 1) {
        if (i == 0) vals.put(i, 0)
        else if (i == 1 || i == 2) vals.put(i, 1)
        else {
            if (!vals.containsKey(i)) vals.put(i, vals.getValue(i - 1) + vals.getValue(i - 2))
        }
    }

    return vals.getValue(num - 1) + vals.getValue(num - 2)
}

fun fibRecursive(num: Int): Int {
    if (num == 0) return 0
    if (num == 1) return 1

    return fibRecursive(num + 1) + fibRecursive(num + 2)
}