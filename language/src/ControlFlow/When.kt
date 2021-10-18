package ControlFlow

class When {
    fun doWhenStatement(param: Any) {
        when (param) {
            1 -> println("One")
            "Hello" -> println("hello")
            is Long -> println("Long")
            else -> println("unknown")
        }
    }

    fun doWhenExpression(param: Any): String {
        val ret = when (param) {
            1 -> "one"
            "Hello" -> "hello"
            is Long -> "Long"
            else -> "Unknonw"
        }

        return ret
    }
}

fun main() {
    When().doWhenStatement("Hello")
    When().doWhenStatement(1)
    When().doWhenStatement(20L)
    When().doWhenStatement(myClass())

    println(When().doWhenExpression("Hello"))
    println(When().doWhenExpression(1))
    println(When().doWhenExpression(20L))
    println(When().doWhenExpression(myClass()))
}

class myClass