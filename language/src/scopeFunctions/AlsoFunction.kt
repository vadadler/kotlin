package scopeFunctions

/*
 * Context object : it
 * Return value   : context object
 * Use Case       : It is used where we have to perform additional operations when we have initialized the object members.
 */

class AlsoFunction {
}

fun main() {
    var v1 = 1
    var v2 = 2

    println("Before swap v1=$v1, v2=$v2")
    v1 = v2.also { v2 = v1 }
    println("After swap v1=$v1, v2=$v2")
}