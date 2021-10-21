class Tutti {
}

fun main() {
    // Swap two variables.
    var v1 = 1
    var v2 = 2
    println("Before swap v1=$v1 v2=$v2")
    v1 = v2.also { v2 = v1 }
    println("After swap v1=$v1 v2=$v2")

    val numbers = mutableListOf("one", "two", "three")
    numbers
        .also { println("The list elements before adding new one: $it") }
        .add("four")

    numbers.also { println("The list elements after adding one: $it") }
}