package controlFlow

class When {
    fun doWhenStatement(param: Any) {
        when (param) {
            1 -> println("One")
            "Hello" -> println("hello")
            is Long -> println("Long")
            else -> println("unknown")
        }
    }

    fun doWhenExpression(param: Any): Any {
        val ret = when (param) {
            1 -> 1
            "Hello" -> "hello"
            is Long -> 12L
            else -> 72
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