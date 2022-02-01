package datastructures

class LinkedList<T: Any> {
    var head: Node<T>? = null
    var tail: Node<T>? = null
    var size = 0

    // Add node at the front/head.
    fun push(value: T) {
        val n = Node(value, head)

        if(head == null) {
            head = n
        } else {
            n.next = head
            head = n
        }

        size++
    }

    // Append value at the tail.
    fun append(value: T) {
        val n = Node(value, null)

        if (head == null) {
            push(value)
        } else if (tail == null) {
            head?.next = n
            tail = n
        } else {
            tail?.next = n
            tail = n
        }

        size++
    }

    // Insert node at a position in the list.
    fun insertAt(pos: Int, n: Node<T>) {
        var nodeToInsertAt = head

        // A little optimization.
        when (pos) {
            0 -> { push(n.value) }
            (size - 1) -> { append(n.value) }
            else -> {
                for (i in 0..pos) {
                    nodeToInsertAt = nodeToInsertAt?.next
                }

                val nodeTemp = nodeToInsertAt?.next
                nodeToInsertAt?.next = n
                n.next = nodeTemp

            }
        }

    }

    override fun toString(): String {
        var n = head
        var str = StringBuilder()

        while(n?.next != null) {
            str.append("${n.value}-->")
            n = n?.next
        }
        str.append(n?.value)

        return str.toString()
    }
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
    var ll = LinkedList<Int>()
    with(ll) {
        push(2)
        append(1)
        push(3)
        append(6)
        push(4)

        println("Before insert $this")
        insertAt(2, Node(7, null))
        println("After insert $this")
    }
}