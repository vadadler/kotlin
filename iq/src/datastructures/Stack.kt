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

    // Create static factory method to create Stack.
    // To simulate static behavior, use companion object.
    companion object {
        fun create(items: Iterable<Int>): Stack<Int> {
            val stack = Stack<Int>()
            for (item in items) {
                stack.push(item)
            }
            return stack
        }
    }
}

fun reverseLinkedList(ll: LinkedList<Int>): LinkedList<Int>? {
    val st = Stack.create(ll)
    var retList = LnkedList

    return null
}

fun main() {
    val st = Stack<Int>().apply {
        push(1)
        push(2)
        push(3)
        push(4)
        push(5)
    }

    print(st)

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

}