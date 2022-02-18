package datastructures

/*
 * Stacks are crucial to problems that search trees and graphs. Imagine finding your way through a maze. Each time you
 * come to a decision point of left, right or straight, you can push all possible decisions onto your stack. When you
 * hit a dead end, backtrack by popping from the stack and continuing until you escape or hit another dead end.
 */
interface IStack2<T: Any> {
    fun push(element: T)
    fun peek(): T?
    fun pop(): T?
    val size: Int
        get() = size
    val count: Int
    val isEmpty: Boolean
        get() = count == 0
}

class Stack2<T: Any>: IStack<T> {
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

    override fun toString(): String {
        return data.toString()
    }

    override val count: Int
        get() = size
}

fun main() {
    var s = `Stack.kt`<Int>().apply {
        push(3)
        push(4)
    }.also {
        println("Stack -> ${it}")
        println("Pop -> ${it}")
        println("Stack -> ${it}")
    }.also {
        it.push(5)
        it.push(2)

        println("Stack -> ${it}")
        println("Pop -> ${it.pop()}")
        println("Stack -> ${it}")
    }
}