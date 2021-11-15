package datastructures

interface Queue<T : Any> {
    fun enqueue(element: T): Boolean
    fun dequeue(): T?
    val count: Int
        get
    val isEmpty: Boolean
        get() = count == 0
    fun peek(): T?
}

//class ArrayListQueue<T : Any> : Queue<T> {
//    private val list = arrayListOf<T>()
//
//
//}
