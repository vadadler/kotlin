package datastructures

class Stack {
    private var data =  mutableListOf<Any>()
    private var size = 0

    fun push(element: Any) {
        data.add(element)
        size++
    }

    fun pop(): Any {
        val v = data[size - 1]
        data.removeAt(size - 1)
        size--
        return v
    }

    fun peek(): Any {
        return data[size - 1]
    }

    fun isEmtpy(): Boolean {
        return data.size > 0
    }

    fun size(): Int {
        return data.size
    }

    fun ts(): String {
        return data.toString()
    }
}

fun main() {
    var s = Stack()
    s.push(3)
    s.push(4)

    println("Stack -> ${s.ts()}")
    println("Pop -> ${s.pop()}")
    println("Stack -> ${s.ts()}")

    s.push("one")
    s.push(2)

    println("Stack -> ${s.ts()}")
    println("Pop -> ${s.pop()}")
    println("Stack -> ${s.ts()}")
}