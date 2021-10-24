package scopeFunctions

/*
 * Context object : this
 * Return value   : context object
 * Use Case       : “Apply these to the object”. It can be used to operate on members of the receiver object mostly to
 *                  initialize members. In other words, use if for object configuration.
 *                  The apply block is useful if the result needs to be the context object It is most commonly used to do
 *                  additional configuration of objects that have already been instantiated.
 *
 * Definition of apply function: inline fun <T> T.apply(block: T.() -> Unit): T
 *
 * The apply function is an extension function on any generic type T, which calls the specified block with this as
 * its receiver and returns this when it completes.
 */
class ApplyFunction {
}

class Person {
    lateinit var firstName: String
    lateinit var lastName: String
    var height: Int = 0
    var weithg: Float = 0.0f
}

fun main() {
    val mike = Person().apply {
        this.firstName = "Mike"
        this.lastName = "Boles"
        this.height = 72
        this.weithg = 150.8F
    }

    println("Full name ${mike.firstName}, ${mike.lastName}")
}