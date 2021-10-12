fun main() {
    println("sum of 0 = " + sum1toN(0))
    println("sum of 1 = " + sum1toN(1))
    println("sum of 5 = " + sum1toN(5))
    println("Recursive solution:")
    println("sum of 5 = " + sum1toNR(5))
    println("sum of 0 = " + sum1toNR(0))
    println("sum of 1 = " + sum1toNR(1))

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