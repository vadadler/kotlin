package datastructures

import kotlin.jvm.internal.Intrinsics
import kotlin.Int

interface IStack<Int> {
    fun push(element: Int)
    fun pop(): Int?
    fun isEmpty(): Boolean
    fun size(): kotlin.Int
}

class Stack<Int>:IStack<Int> {
    var data = arrayListOf<Int>()
    var head: Int? = null
    var size = 0

    public override fun push(value: Int) {
        data.add(size, value)
        head = value
        size++
    }

    public override fun pop(): Int? {
        if (head == null) return null
        val retVal =  head
        data.removeAt(size - 1)
        size--
        head = data.elementAt(size - 1)
        return retVal
    }

    public override fun isEmpty(): Boolean {
        return size == 0
    }

    public override fun size(): kotlin.Int = size

    public override fun toString(): String {
        println("---top---")
        for (i in size - 1 downTo 0) println(data.elementAt(i))
        println("---bottom---")
        return ""
    }
}

fun main() {
    var st = Stack<Int>()
    st.push(1)
    st.push(2)
    st.push(3)
    st.push(4)
    st.push(5)

    println(st)

    println("popped ${st.pop()}")
    println(st)
}