package datastructures

/*
 Methods to implement:
 toString() For both list and single node.
 push(value: Any) Add node at the head.
 append(value: Any) Add node at the tail.
 getAt(pos: Int): Node Get node at a position.
 insertAt(pos: Int) Insert node at a position.
 deleteAt(pos: Int) Delete node at a position.
 deDup() Remove duplicate nodes.
 isEmpty(): Boolean Check if list is empty.
 */
class SinglyLinkedList<T: Any> {
    data class Node<T:Any>(val value: T, var next: Node<T>? = null) {
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

    fun append(value: T) {
        var node = Node(value, null)
        if (tail != null) {
            tail?.next = node
        }
        tail = node
    }

    fun insertAt(value: T, pos: Int) {
        var node = Node(value, null)

        if (pos == 1) {
            push(value)
        }

        var node2 = getAt(pos - 1)
        if (node2 != null) {
            var tempNode = node2.next
            node2.next = node
            node.next = tempNode
        }

        size++
    }

    fun deleteAt(pos: Int) {
        var node = getAt(pos - 1)

        if (pos == size + 1) {
            node?.next = null
            tail = node
        } else if (pos == 1) {
            head = head?.next
        } else {
            node?.next = node?.next?.next
        }

        size--
    }

    fun getAt(pos: Int): Node<T>? {
        if (pos <= 0 || pos > size) return null

        var node = head;
        for(i in 0..size) {
            if (i + 1 == pos) break
            node = node?.next
        }

        return node
    }

}

fun main() {
    var list = SinglyLinkedList<Int>()

    with(list) {
        push(4)
        push(3)
        push(2)
        push(1)
        append(5)

        println(list)
        println("Head: $head")
        println("Tail: $tail")

        insertAt(0, 5)
        println("After insert: $list")
        println("Head: $head")
        println("Tail: $tail")

        deleteAt(1)
        println("After delete: $list")
        println("Head: $head")
        println("Tail: $tail")

    }

}
