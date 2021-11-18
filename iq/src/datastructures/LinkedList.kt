package datastructures

class LinkedList<T: Any> {
    var head: Node<T>? = null
    var tail: Node<T>? = null
}

data class Node<T: Any>(var value: T, var next: Node<T>?) {
    override fun toString(): String {
        if (next != null) {
            return "$value --> ${next.toString()}"
        }
        return "$value"
    }
}

fun main() {
    val n4 = Node(4, null)
    val n3 = Node(3, n4)
    val n2 = Node(2, n3)
    val n1 = Node(1, n2)

    print(n1)
}