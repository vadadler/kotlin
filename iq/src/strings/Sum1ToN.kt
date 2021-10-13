package strings

/*
 Write a function to sum numbers from 1 to N. For example, sum1toN(5) = 1+2+3+4+5 = 12
 */
class Sum1ToN {
    fun sum1ToN(num: Int):Int {
        if (num == 0 || num == 1) {
            return num
        }

        var sum = 0
        var i = 1
        while (i < num) {
            sum += i++
        }

        return sum
    }

    fun sum1ToNR(num: Int): Int {
        if(num == 1 || num == 0) return num
        return num + sum1ToNR(num - 1)
    }

    fun sum1ToNFold(num: Int) = (1..num).fold(0) {acc, x -> acc+x}
}

fun main() {
    println("Sum of 0 = ${Sum1ToN().sum1ToN(0)}" )
    println("Recursive Sum of 0 = ${Sum1ToN().sum1ToNR(0)}" )

    println("Sum of 1 = ${Sum1ToN().sum1ToN(1)}" )
    println("Recursive Sum of 1 = ${Sum1ToN().sum1ToNR(1)}" )

    println("Sum of 5 = ${Sum1ToN().sum1ToN(5)}" )
    println("Recursive Sum of 5 = ${Sum1ToN().sum1ToNR(5)}" )

    println("Using fold Sum of 5 = ${Sum1ToN().sum1ToNFold(5)}" )
}