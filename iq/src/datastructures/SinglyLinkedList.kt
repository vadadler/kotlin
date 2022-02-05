package datastructures

/*
 Methods to implement:
 toString() For both list and single node.
 push(value: Any) Add node at the head.
 append(value: Any) Add node at the tail.
 getAt(pos: Int): Node Get node at a position.
 getNthFromTail(pos: Int): Node Get Nth node from the tail.
 insertAt(pos: Int) Insert node at a position.
 deleteAt(pos: Int) Delete node at a position.
 deDup() Remove duplicate nodes.
 isEmpty(): Boolean Check if list is empty.
 deleteNthNode() Delete Nth node. You have access to Nth node only.
 */
class SinglyLinkedList<T: Any> {
    data class Node<T:Any>(var value: T, var next: Node<T>? = null) {
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
        size++
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

    fun getAtPos(pos: Int): Node<T>? {
        var node = head
        for (i in 1..size) {
            if (i == pos) {
                return node
            }
            node = node?.next
        }

        return null
    }

    // If size is known.
    fun getNthFromTail(pos: Int):Node<T>? {
        return getAtPos(size - pos + 1)
    }

    // Size is unknown.
    fun getNthFromTailNoSize(pos: Int): Node<T>? {
        var node = head
        var tempNode = head

        for (i in 1..size) {
            tempNode = node

            for (j in 1..pos - 1) {
                tempNode = tempNode?.next
            }

            if (tempNode?.next == null) {
                break
            }

            node = node?.next
        }

        return node
    }

    // Using helper HashSet.
    fun deDup() {
        var values = HashSet<T>()

        var node = head
        var prevNode = head

        while (node != null) {
            if (values.contains(node?.value)) {
                prevNode?.next = node?.next
                size--

                if (node == tail) {
                    tail = prevNode
                }
            } else {
                if (node != null) {
                    values.add(node.value)
                }
            }
            prevNode = node
            node = node?.next
        }
    }

    // Recursive solution.
    // Alternative to having temp storage.
    // deDup starting from head to tail.
    // then from head.next to tail
    // then from head.next.next to tail etc.
    fun deDup2() {
        var h =  head
        dd(h)
    }

    private fun dd(h: Node<T>?) {
        val value = h?.value
        var node = h?.next
        var prevNode = h

        if (node == null) return

        while (node != null || node == tail) {
            if (node?.value == value) {
                if (node == tail) {
                    tail = prevNode
                }
                prevNode?.next = node?.next
                size--
            }
            else {
                prevNode = node
            }

            node = node?.next
        }

        dd(h?.next)
    }

    // You don't have access to list's head.
    // Copy value from next to current. Repeat until the end.
    fun deleteNthNode(pos: Int) {
        var node = getAtPos(pos)
        while(node?.next != null) {
            node?.value = node?.next?.value!!
            if (node?.next?.next != null) {
                node = node.next
            } else {
                break
            }
        }

        node?.next = null
        tail = node
        size--
    }
}

fun main() {
    var list = SinglyLinkedList<Int>()

    with(list) {
        push(1)
        push(4)
        push(3)
        push(2)
        push(1)
        append(5)
        append(4)

        println(list)
        println("Head: $head")
        println("Tail: $tail")
//
//        insertAt(0, 5)
//        println("After insert: $list")
//        println("Head: $head")
//        println("Tail: $tail")
//
//        deleteAt(1)
//        println("After delete: $list")
//        println("Head: $head")
//        println("Tail: $tail")

        deDup2()
        println("After deDup: $list")
        println("Head: $head")
        println("Tail: $tail")


        val pos = 3
        var node = getNthFromTail(pos)
        println("getNthFromTail($pos): $node")
        println("Head: $head")
        println("Tail: $tail")

        node = getNthFromTailNoSize(pos)
        println("getNthFromTailNoSize($pos): $node")
        println("Head: $head")
        println("Tail: $tail")

        deleteNthNode(3)
        println("After delete: $list")
        println("Head: $head")
        println("Tail: $tail")

    }

}
