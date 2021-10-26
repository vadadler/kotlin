package scopeFunctions

/*
 * Context object : it
 * Return value   : context object
 * Use Case       : It is used where we have to perform additional operations on an object without interrupting flow of the code.
 *                  It is most commonly used to chain a function call onto an object.
 */

class AlsoFunction {
}

fun main() {
    var v1 = 1
    var v2 = 2

    println("Before swap v1=$v1, v2=$v2")
    v1 = v2.also { v2 = v1 }
    println("After swap v1=$v1, v2=$v2")

    val list = mutableListOf(1,2,3,4)
    list.also { it.add(5) }
        .also { it.remove(1)}
        .also { println(it) }
}