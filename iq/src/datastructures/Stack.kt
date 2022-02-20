package datastructures

import java.util.LinkedList
import kotlin.jvm.internal.Intrinsics
import kotlin.Int

interface IStack<Int> {
    fun push(element: Int)
    fun pop(): Int?
    val isEmpty: Boolean
    val length: kotlin.Int
    fun peek(): Int?
}

class Stack<Int>:IStack<Int> {
    var data = arrayListOf<Int>()

    override fun push(value: Int) {
        data.add(value)
    }

    override fun pop(): Int? {
        if (isEmpty) return null
        return data.removeAt(length - 1)
    }

    override val isEmpty = data.size == 0

    override fun peek(): Int? {
        return data.lastOrNull()
    }

    override val length = data.size

    override fun toString() = buildString {
        appendLine("---top---")
        data.asReversed().forEach{
            appendLine("$it")
        }
        appendLine("---bottom---")
    }
}

fun reverseLinkedList(ll: LinkedList<Int>): LinkedList<Int>? {
    return null
}

fun main() {
    var ll = LinkedList<Int>()
    with (ll) {
        add(1)
        add(2)
        add(3)
        add(4)
        add(5)

        println(this)

        
    }

}