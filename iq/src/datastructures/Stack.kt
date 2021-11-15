package datastructures

class Stack {
    private var data =  mutableListOf<Int>()

    fun push(element: Int) {
        data.add(element)
    }

    fun pop(): Int {
        val top = data.size - 1
        val v = data[top]
        data.remove(top)
        return v
    }

    fun peek(): Int {
        return data[data.size - 1]
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
}