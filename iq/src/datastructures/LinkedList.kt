package datastructures

class LinkedList<T: Any> {
    var head: Node<T>? = null
    var tail: Node<T>? = null
    var size = 0

    // Add node in the front.
    fun push(value: T) {
        var n = Node(value, head)

        if (head != null) {
            tail = head
        }

        head = n

        size++
    }

    // Add node at the end.
    fun append(value: T) {
        var n = Node(value, null)

        if (head != null) {
            tail?.next = n
            tail = n
        }
        size++

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
//    val n4 = Node(4, null)
//    val n3 = Node(3, n4)
//    val n2 = Node(2, n3)
//    val n1 = Node(1, n2)

//    print(n1)

    var ll = LinkedList<Int>()
    ll.append(1)
    ll.push(2)
    ll.push(3)
    ll.append(0)
    ll.push(4)

    print(ll)
}