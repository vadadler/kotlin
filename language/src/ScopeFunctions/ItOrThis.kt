package ScopeFunctions

import kotlin.properties.Delegates

/*
Inside the lambda of a scope function, the context object is available by a short reference instead of its actual name.
Each scope function uses one of two ways to access the context object: as a lambda receiver (this) or as a lambda
argument (it). Both provide the same capabilities
 */
interface ItOrThis {
}

fun main() {
    val str = "Hello, World!"

    class Person {
        var height: Int = 0
        var weight: Float = 0.0f
        lateinit var firstName: String
        lateinit var lastName: String
    }

    // this: with, run, apply
    str.run { println("The length of the string $str is ${this.length}") }
    str.run { println("The length of the string $str is $length") }

    with(str) {
        println("To uppercase string $str is ${this.uppercase()}")
        //Ommiting this for some object functions is impossible.
        //println("To uppercase string $str is $uppercase()")
    }

    Person().apply {
        this.height = 82
        this.weight = 159.2F
        this.firstName = "John"
        this.lastName = "Doe"

        println(this.lastName)
    }

    println()


    // it: let, also
}