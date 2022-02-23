package datastructures

import java.util.LinkedList
import kotlin.jvm.internal.Intrinsics
import kotlin.Int
import kotlin.test.assertFalse

interface IStack<Int> {
    fun push(element: Int)
    fun pop(): Int?
    val isEmpty: Boolean
    val length: kotlin.Int
    fun peek(): Int?
}

interface IStack2<Int> {
    fun push(element: kotlin.Int)
    fun pop(): Int?
    val isEmpty: Boolean
    val length: Int
    fun peek(): Int?
    fun min(): Int
}

data class StackValue(var value: Int, var min: Int)

class Stack<Int>:IStack<Int> {
    var data = arrayListOf<Int>()

    override fun push(value: Int) {
        data.add(value)
    }

    override fun pop(): Int? {
        if (isEmpty) return null
        return data.removeAt(length - 1)
    }

    override val isEmpty: Boolean
        get() = data.size == 0

    override fun peek(): Int? {
        return data.lastOrNull()
    }

    override val length: kotlin.Int
        get() = data.size

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

class Stack2<Int>:IStack2<Int> {
    var data = arrayListOf<StackValue>()

    override fun push(element: kotlin.Int) {
        var e = StackValue(element, 0)
        if (data.size == 0) {
            e.min = element
            data.add(e)
        }
    }

    override fun pop(): Int? {
        TODO("Not yet implemented")
    }

    override val isEmpty: Boolean
        get() = TODO("Not yet implemented")

    override val length: Int
        get() = TODO("Not yet implemented")

    override fun peek(): Int? {
        TODO("Not yet implemented")
    }

    override fun min(): Int {
        TODO("Not yet implemented")
    }


}

// Reverse a LinkedList.
// Given a linked list, print the nodes in reverse order. You should not use recursion to solve this problem.
fun reverseLinkedList(ll: LinkedList<Int>): LinkedList<Int>? {
    val st = Stack.create(ll)
    var retList = LinkedList<Int>()

    var node = st.pop()
    while(node != null) {
        retList.add(node)
        node = st.pop()
    }

    return retList
}

// The parentheses validation
// Check for balanced parentheses. Given a string, check if there are ( and ) characters, and return true if the
// parentheses in the string are balanced.
// Solution: walk input string char by char. If found ( push to stack, if found ) pop the stack. At the end if
// stack is empty parantheses are balanced. Otherwise, they are not.
//
// h((e))llo(world)() // balanced parentheses
// (hello world // unbalanced parentheses
fun isBalanceParentheses(input: String): Boolean {
    var st = Stack<Int>()

    for (ch in input) {
        if (ch == '(') {
            st.push(1)
        }
        else if (ch ==')')  {
            if (!st.isEmpty) st.pop()
            else return false
        }
    }
    return st.isEmpty
}

// Implement 3 stacks using one array.
// Divide array in 3 parts. Use each part as storage for one stack.
fun oneArray3Stacks(array: IntArray) {
    class Stack<Int>(len: kotlin.Int) {
        val data = IntArray(len)
        var top: kotlin.Int = 0
        val isEmpty: Boolean
            get() = top == 0

        fun push(v: kotlin.Int) {
            if (top == data.size) throw ArrayIndexOutOfBoundsException()
            data[top] = v
            top++
        }

        fun pop() {
            var retVal: kotlin.Int
            if (!isEmpty) {
                retVal = data.elementAt(top)
                top--
            }
        }
    }
}

fun main() {
//    val st = Stack<Int>().apply {
//        push(1)
//        push(2)
//        push(3)
//        push(4)
//        push(5)
//    }
//
//    print(st)

    var ll = LinkedList<Int>()
    with (ll) {
        add(1)
        add(2)
        add(3)
        add(4)
        add(5)

        println(this)
    }

    println(reverseLinkedList(ll))

    val str = "(he(llo)"
    println("Is () balanced in $str: ${isBalanceParentheses(str)}")
}