package datastructures

/*
    Methods:
    push(value: T) Insert node at the head.
    append(value: T) Insert node at the tail.
    isEmpty(): Boolean Check if list is empty.
    insertAt(position: Int) Insert node at position.
    getAt(position: Int)?: Node Get node at position.
    deleteAt(position: Int) Delete node at position.
 */
class LinkedList<T: Any> {
    var head: Node<T>? = null
    var tail: Node<T>? = null
    var size = 0

    data class Node<T: Any> (val value: T, var next: Node<T>?) {
        override fun toString(): String {
            return value.toString()
        }
    }

    fun isEmpty(): Boolean {
        return when (size) {
            0 -> true
            else -> false
        }
    }

    private fun getAt(pos: Int): Node<T>? {
        if(pos > size || pos <= 0) return null

        var node = head

        for (i in 1..size + 1) {
            if (i == pos) return node
            node = node?.next
        }

        return node
    }

    // insertAt(2, 0)
    // 1-->2-->3-->4
    //     ^
    // 1-->0-->2-->3-->4
    // If pos <= 0 Insert at head. If pos > size Insert at tail.
    fun insertAt(pos: Int, value: T) {
        val node = getAt(pos - 1)

        if (node != null) {
            node.next = Node(value, node.next)
        }
        else { // Insert at head or at tail.
            if (pos == 0) push(value)
            else append(value)
        }

        size++
    }

    // deleteAt(2)
    //1-->2-->3-->4
    //    ^
    //1-->3-->4
    fun deleteAt(pos: Int) {
        val prevNode = getAt(pos - 1)
        if (prevNode == null) {
            head = head?.next
        }
        else {
            prevNode?.next = prevNode?.next?.next

            if(prevNode?.next == null) {
                tail = prevNode
            }
        }

        size--
    }

    // Add node at the front/head.
    fun push(value: T) {
        val n = Node(value, null)

        if(head == null) {
            head = n
            tail = n
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
    fun insertAt2(pos: Int, n: Node<T>) {
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

    fun deDup() {
        var tmp: HashSet<Any?> = HashSet()
        var node = head
        while (node?.next != null) {
            if (tmp.contains(node?.next?.value)) {
                node.next = node?.next?.next
                size--
            }
            else {
                tmp.add(node.value)
            }
            node = node.next
        }
    }
}

fun main() {
    var ll = LinkedList<Int>()
    with(ll) {
        push(4)
        push(3)
        push(2)
        push(1)
        push(3)

        println("head: $head")
        println("tail: $tail")

        println("Before insert $this")
        insertAt(4, 0)
        println("After insert $this")

        println("head: $head")
        println("tail: $tail")

//        println("Before delete $this")
//        deleteAt(1)
//        println("After delete $this")

        println("head: $head")
        println("tail: $tail")

        println("Before deDup $this")
        deDup()
        println("After deDup $this")

    }
}