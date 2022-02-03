package datastructures

/*
 Methods to implement:
 toString() For both list and single node.
 push(value: Any) Add node at the head.
 append(value: Any) Add node at the tail.
 insertAt(pos: Int) Insert node at a position.
 deleteAt(pos: Int) Delete node at a position.
 deDup() Remove duplicate nodes.
 isEmpty(): Boolean Check if list is empty.
 */
class SinglyLinkedList<T: Any> {
    data class Node<T:Any>(val value: T, var next: Node<T>?) {
        override fun toString(): String {
            return value.toString()
        }
    }

    var head: Node<T>? = null
    var tail: Node<T>? = null
    var size = 0

    fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toString():String {
        var ret = StringBuilder()
        var node = head
        ret.append(node.toString())
        while (node?.next != null) {
            ret.append("-->${node?.next.toString()}")
            node = node?.next
        }

        return ret.toString()
    }

    fun push(value: T) {
        var node = Node(value, null)
        node.next = head
        head = node
        size++

        if (size == 1) {
            tail = node
        }
    }

}

fun main() {
    var list = SinglyLinkedList<Int>()

    with(list) {
        push(4)
        push(3)
        push(2)
        push(1)

        println(list)
        println("Head: $head")
        println("Tail: $tail")
    }

}
