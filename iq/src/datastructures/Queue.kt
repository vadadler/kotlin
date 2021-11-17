package datastructures

interface IQueue<T: Any> {
    fun enqueue(element: T): Boolean
    fun dequeue(): T?
    val count: Int
    val isEmpty: Boolean
        get() = count == 0
    fun peek(): T?
}

class ArrayListQueue<T: Any>: IQueue<T> {
    private val list = arrayListOf<T>()

    override val count: Int
        get() = TODO("Not yet implemented")

    override fun enqueue(element: T): Boolean {
        TODO("Not yet implemented")
    }

    override fun dequeue(): T? {
        TODO("Not yet implemented")
    }

    override fun peek(): T? {
        TODO("Not yet implemented")
    }
}
