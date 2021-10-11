package modifiers

// The lateinit keyword is used for late initialization of variables.

lateinit var lateinitVar: String

val lateLambda = {  println(lateinitVar) }

//class A {
//    public lateinit var lateinitVar: String
//}

fun main() {
    // Reference uninitialized variable. Get exception.
    try {
        lateLambda()
    }
    catch (e: Exception) {
        println("Exception: ${e.localizedMessage}")
    }

    // Check if variable was initialized.
//    if (A().lateinitVar.isInitialized)) {
//        println("lateinit var was initialized")
//    }
//    else {
//        println("lateinit var was not initialized")
//    }

    // Variable is initialized before referenceing it.
    lateinitVar = "Hello, World!"
    lateLambda()
}