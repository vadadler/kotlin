package datastructures

interface IStack<T: Any> {
    fun push(element: T)
    fun peek(): T?
    fun pop(): T?
    val size: Int
        get() = size
    val count: Int
    val isEmpty: Boolean
        get() = count == 0
}

class Stack<T: Any>: IStack<T> {
    private var data =  mutableListOf<T>()

    override fun push(element: T) {
        data.add(element)
    }

    override val size: Int
        get() = data.size

    override fun pop(): T? {
        if (size == 0) return null
        return data.removeAt(size - 1)
    }

    override fun peek(): T? {
        return data.lastOrNull()
    }

    fun ts(): String {
        return data.toString()
    }

    override val count: Int
        get() = size
}

fun main() {
    var s = Stack<Int>().apply {
        push(3)
        push(4)
    }.also {
        println("Stack -> ${it.ts()}")
        println("Pop -> ${it.pop()}")
        println("Stack -> ${it.ts()}")
    }.also {
        it.push(5)
        it.push(2)

        println("Stack -> ${it.ts()}")
        println("Pop -> ${it.pop()}")
        println("Stack -> ${it.ts()}")
    }
}