package datastructures

interface IStack<Int> {
    fun push(element: Int)
    fun pop(): Int?
    fun isEmpty(): Boolean
    fun size(): Int
}

class Stack<Int>:IStack<Int> {

    var head: Int? = null
    var size: Int = 0

    public override fun push(value: Int) {

    }

    public override fun pop(): Int? {
        return head ?: null
    }

    public override fun isEmpty(): Boolean {
        return size == 0
    }

    public override fun size(): Int = size
}