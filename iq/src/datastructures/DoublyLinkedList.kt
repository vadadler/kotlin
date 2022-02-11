package datastructures

/*
 Methods to implement:
 toString() For both list and single node.
 push(value: Any) Add node at the head.
 append(value: Any) Add node at the tail.
 getAt(pos: Int): Node Get node at a position.
 getNthFromTail(pos: Int): Node Get Nth node from the tail.
 getNthFromTailNoSize(pos: Int): Node. Get Nth node from tail not knowing size of the list.
 getNthFromTailNoSizeRecursive(pos: Int): Node. Get Nth node from tail not knowing size of the list. Use recursion.
 insertAt(pos: Int) Insert node at a position.
 deleteAt(pos: Int) Delete node at a position.
 deDup() Remove duplicate nodes.
 isEmpty(): Boolean Check if list is empty.
 deleteNthNode() Delete Nth node. You have access to Nth node only.
 partitionListAroundValue(value: T> Partition list around value, such that all nodes with less value are left and grater values are right to that value.
 isPalindrome(): Boolean Check if SLL palindrome.
 */
class DoublyLinkedList {
    data class Node<Int>(var value: Int, var prev: Node<Int>?, var next: Node<Int>?) {
        override fun toString(): String {
            return value.toString()
        }
    }

    override fun toString(): String {
        var str = StringBuilder()
        var node = head

        for (i in 1..size) {
            if (i == size) {
                str.append(node)
            } else {
                str.append("$node<-->")
            }
            node = node?.next
        }

        return str.toString()
    }

    var head: Node<Int>? = null
    var tail: Node<Int>? = null
    var size = 0


    // Add value at the head.
    fun push(value: Int) {
        var node = Node(value, null, null)

        if (head == null) {
            head = node
        } else {
            head?.prev = node
            node.next = head
            head = node
        }

        size++
    }

    // Insert node at the tail.
    fun append(value: Int) {
        var node = Node(value, null, null)

        if (head == null) {
            head = node
            tail = node
        } else {
            tail?.next = node
            node.prev = tail
            tail = node
        }

        size++
    }

    fun getAt(pos: Int): Node<Int>? {
        if (pos == 1) return head
        else if (pos == size) return tail
        else if (pos > 0 && pos <= size) {
            var node = head
            for (i in 1..pos) {
                if (pos == i) return node
                else node = node?.next
            }
        }

        return null
    }

    fun getAtRecursively(pos: Int, currPos: Int, currNode: Node<Int>?): Node<Int>? {
        if (currNode == null) return null

        return if (pos == 1) head
            else if (pos == size) tail
            else if (pos <= 0 || pos > size) null
            else if (pos == currPos) currNode
            else {
                getAtRecursively(pos, currPos + 1, currNode?.next)
            }
    }

    fun getNthFromTail(pos: Int): Node<Int>? {
        var node = tail
        for (i in 1..pos) {
            if (i == pos) return node

            node = node?.prev
        }

        return null
    }

    fun insertAt(pos: Int, value: Int) {
        var node = Node(value, null, null)
        var curr = head

        if (pos == 1) push(value)
        else if (pos == size) append(value)
        else if (pos <= size/2) { // start from head.
            for (i in 1..size/2) {
                if (i == pos) break
                curr = curr?.next
            }
        } else {            // start from tail.
            curr = tail
            for (i in 0..size/2) {
                if (i == pos) break
                curr = curr?.prev
            }
        }

        node.prev = curr?.prev
        node.next = curr
        node.prev?.next = node
        curr?.prev = node
        size++
    }

    fun deleteAt(pos: Int, value: Int) {

    }
 }

fun main() {
    var dll = DoublyLinkedList()
    with(dll) {
        append(2)
        push(1)
        append(3)
        append(4)
        append(5)
    }

    println(dll)
    val pos = 2
    val value = 6
    println("getAt($pos)=${dll.getAt(pos)}")
    println("getAtRecursively($pos)=${dll.getAtRecursively(pos, 1, dll.head)}")
    println("getNthFromTail($pos)=${dll.getNthFromTail(pos)}")
    dll.insertAt(pos, value)
    println("insertAt($pos, $value)=$dll")

}