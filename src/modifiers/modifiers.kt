package modifiers

import java.lang.Exception

// The lateinit keyword is used for late initialization of variables.

lateinit var lateVar: String

val lateLamda = {  println(lateVar) }

fun main() {
    // Reference uninitialized variable. Get exception.
    try {
        lateLamda()
    }
    catch (e: Exception) {
        println("Exception: ${e.localizedMessage}")
    }

    // Check if variable was initialized.
    if (lateVar.isInitialized)

    // Variable is initialized before referenceing it.
    lateVar = "Hello, World!"
    lateLamda()
}