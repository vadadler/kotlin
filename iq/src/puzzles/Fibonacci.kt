package puzzles

import java.math.BigInteger

class Fibonacci {
}

fun main() {
    for (i in 0..7) {
        println("Fib HashMap fib($i) = ${fibHashMap(i)}")
    }

    println("Fib HashMap fib(-5) = ${fibHashMap(-5)}")

    for (i in 0..7) {
        println("Fib iterative fib($i) = ${fibIter(i)}")
    }

    println("Fib iterative fib(-5) = ${fibIter(-5)}")

    for (i in 0..7) {
        println("Fib recursive fib($i) = ${fibRecursive(i)}")
    }

    println("Fib recursive fib(-5) = ${fibRecursive(-5)}")
}

fun fibIter(num: Int): Int {
    if (num <= 0) return 0
    if (num == 1 || num == 2) return 1

    var val1 = 0
    var val2 = 0

    for (i in 3..num) {
        val tmp = val1

        if (i - 1 == 0) val1 = 0
        else if (i - 1 == 1 || i - 1 == 2) val1 = 1
        else val1 += val2

        if (i - 2 == 0) val2 = 0
        else if (i - 2 == 1 || i - 2 == 2) val2 = 1
        else val2 = tmp
    }

    return val1 + val2
}

// Store F(N) in HashMap(N, F(N))
fun fibHashMap(num: Int): Int {
    if (num <= 0) return 0
    if (num == 1 || num == 2) return 1

    var vals = HashMap<Int, Int>()
    for (i in 0..num - 1) {
        if (i == 0) {
            vals.put(i, 0)
        }
        else if (i == 1 || i == 2) {
            vals.put(i, 1)
        }
        else {
            if (!vals.containsKey(i)) {
                vals.put(i, vals.getValue(i - 1) + vals.getValue(i - 2))
            }
        }
    }

    return vals.getValue(num - 1) + vals.getValue(num - 2)
}

fun fibRecursive(num: Int): Int {
    if (num <= 0) return 0
    if (num == 1 || num == 2) return 1

    return fibRecursive(num - 1) + fibRecursive(num - 2)
}