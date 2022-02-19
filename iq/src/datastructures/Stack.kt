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
        if (size == 0) {
            data.add(value)
            head = value
        }
        size++
    }

    public override fun pop(): Int? {
        var retVal: Int? = null
        if (head != null) {
            retVal = head
            data.removeAt(size)
            size--
        }
        return retVal
    }

    public override fun isEmpty(): Boolean {
        return size == 0
    }

    public override fun size(): kotlin.Int = size

    public override fun toString(): String {

    }
}

fun main() {
    var st = Stack<Int>()
    st.push(1)

}