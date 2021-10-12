package modifiers

// https://kotlinlang.org/docs/keyword-reference.html#modifier-keywords
// The lateinit keyword is used for late initialization of variables.

lateinit var lateinitVar: String

val lateLambda = {  println(lateinitVar) }

fun main() {
    // Reference uninitialized variable. Get exception.
    try {
        lateLambda()
    }
    catch (e: Exception) {
        println("Exception: ${e.localizedMessage}")
    }

    // Check if variable was initialized.
    if(::lateinitVar.isInitialized) {
        println("lateinit var was initialized")
    }
    else {
        println("lateinit var was not initialized")
    }

    // Variable is initialized before referencing it.
    lateinitVar = "Hello, World!"
    lateLambda()
}