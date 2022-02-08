package datastructures

import kotlin.math.pow

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
class SinglyLinkedList<T: Any> {
    data class Node<Int>(var value: Int, var next: Node<Int>? = null) {
        override fun toString(): String {
            return value.toString()
        }
    }

    var head: Node<Int>? = null
    var tail: Node<Int>? = null
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

    fun push(value: Int) {
        var node = Node(value, null)
        node.next = head
        head = node
        size++

        if (size == 1) {
            tail = node
        }
    }

    fun append(value: Int) {
        var node = Node(value, null)
        if (tail != null) {
            tail?.next = node
        }

        if (head == null) {
            head = node
        }
        tail = node
        size++
    }

    fun insertAt(value: Int, pos: Int) {
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

    fun getAt(pos: Int): Node<Int>? {
        if (pos <= 0 || pos > size) return null

        var node = head;
        for(i in 0..size) {
            if (i + 1 == pos) break
            node = node?.next
        }

        return node
    }

    fun getAtPos(pos: Int): Node<Int>? {
        var node = head
        for (i in 1..size) {
            if (i == pos) {
                return node
            }
            node = node?.next
        }

        return null
    }

    fun getAtPosRecursive(pos: Int): Node<Int>? {
        
    }

    // If size is known.
    fun getNthFromTail(pos: Int):Node<Int>? {
        return getAtPos(size - pos + 1)
    }

    // Size is unknown.
    fun getNthFromTailNoSize(pos: Int): Node<Int>? {
        var node = head
        var tempNode = head

        while (node?.next != null) {
            tempNode = node

            for (j in 1..pos - 1) {
                tempNode = tempNode?.next
            }

            // At the tail.
            if (tempNode?.next == null) {
                break
            }

            node = node?.next
        }

        return node
    }

    fun getNthFromTailNoSizeRecursive(pos: Int): Node<Int>? {
        return getRecursively(head, pos)
    }

    private fun getRecursively(node: Node<Int>?, pos: Int): Node<Int>? {
        var tempNode = node

        for (i in 1..pos - 1) {
            tempNode = tempNode?.next
        }

        // At the tail.
        if (tempNode?.next == null) {
            return node
        }
        else {
            return getRecursively(node?.next, pos)
        }
    }

    // Assume values are unique in the list.
    // Walk the list. If value is less then make that node head. If greater make it tail.
    fun partitionListAroundValue(value: Int) {
        var node = head
        var prevNode = head

        for (i in 1..size + 1) {
            if (node == null) return

            if (node?.value > value) {  // Move node to the tail.
                if (node == head) {
                    head = node?.next
                    tail?.next = node
                    tail = node
                    tail?.next = null
                    node = head
                } else {
                    prevNode?.next = node?.next
                    tail?.next = prevNode
                    tail = prevNode
                    node = node.next
                }
            } else if (node?.value < value) { // Move node to the head.
                if (node == tail) {
                    node.next = head
                    head = node
                    tail = prevNode
                } else if (node != head) {
                    prevNode?.next = node.next
                    node.next = head
                    head = node
                }
                prevNode = node
                node = node.next
            } else {    // Do nothing/.
                prevNode = node
                node = node.next
            }
        }
    }

    // Using helper HashSet.
    fun deDup() {
        var values = HashSet<Int>()

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
        dd(head)
    }

    private fun dd(h: Node<Int>?) {
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

    fun isPalindrome(): Boolean {
        var isPalindrome = true

        var i = 0
        var j = size

        var nodei = head
        var nodej = tail

        while (i <= j) {
            if (nodei?.value != nodej?.value) {
                return false
            }

            i++
            j--

            nodei = nodei?.next
            nodej = getAt(j)
        }

        return isPalindrome
    }

    // In a circular linked list find node at the beginning of the loop.

    // Assume there is tail.
    fun circularNode(): Node<Int>? {
        var node = head
        for (i in 0..size - 1) {
            if (node?.value == tail?.next?.value) {
                return node
            }

            node = node?.next
        }

        return null
    }

    // Assume there is no tail.
    fun circularNodeNoTail(): Node<Int>? {
        var node = head
        for (i in 0..size - 1) {
            if (node?.value == tail?.next?.value) {
                return node
            }

            node = node?.next
        }

        return null
    }

}

// Lists are the same length.
// Two numbers represented as SLL where each node contains single digit. The digits are stored in reverse order.
// Example:
// Input: (7->1->6) + (5->9->2) That is 617+295
// Output: 2->1->9 That is, 912
fun addTwoLists(list1: SinglyLinkedList<Int>, list2: SinglyLinkedList<Int>): SinglyLinkedList<Int> {
    var node1 = list1.head
    var node2 = list2.head

    var sum1 = 0
    var sum2 = 0

    for (i in 0..list1.size - 1) {
        sum1 += (node1?.value!!) * (10.0).pow(i).toInt()
        sum2 += (node2?.value!!) * (10.0).pow(i).toInt()

        node1 = node1.next
        node2 = node2.next
    }

    val sum = sum1 + sum2

    println("Sum1=${sum1}")
    println("Sum2=${sum2}")
    println("Sum=${sum}")

    var remainder = sum
    var linkedList = SinglyLinkedList<Int>()
    for (i in list1.size - 1 downTo 0) {
        var value = remainder / (10.0).pow(i).toInt()
        remainder = remainder % (10.0).pow(i).toInt()
        linkedList.push(value)
    }
    return linkedList
}

// Lists are the same length.
// Two numbers represented as SLL where each node contains single digit.
// Example:
// Input: (7->1->6) + (5->9->2) That is 716+295
// Output: 1->3->0->8 That is, 1308
fun addTwoLists2(list1: SinglyLinkedList<Int>, list2: SinglyLinkedList<Int>): SinglyLinkedList<Int> {
    var sum1 = 0
    var sum2 = 0
    var node1 = list1.head
    var node2 = list2.head

    for (i in list1.size - 1 downTo 0) {
        sum1 += node1?.value!! * 10.0.pow(i).toInt()
        sum2 += node2?.value!! * 10.0.pow(i).toInt()
        node1 = node1.next
        node2 = node2.next
    }

    var sum = sum1 + sum2

    println("Sum1=${sum1}")
    println("Sum2=${sum2}")
    println("Sum=${sum}")

    var remainder1 = sum1
    var remainder2 = sum2

    var remainder = sum
    var retList = SinglyLinkedList<Int>()

    var numDigits = sum.toString().length

    for (i in numDigits - 1 downTo 0) {
        var value = remainder / (10.0.pow(i)).toInt()
        remainder = remainder % (10.0.pow(i)).toInt()
        retList.append(value)
    }

    return retList
}

fun main() {
    var sll = SinglyLinkedList<Int>()
    with(sll) {
        push(5)
        push(4)
        push(3)
        push(2)
        push(1)

        tail?.next = getAt(3)
    }

    println("Start of the loop ${sll.circularNode()}")
//        push(3)
//        push(2)
//        push(1)
//        append(2)
//        append(1)
//
//        println(this)
//        println("Head: $head")
//        println("Tail: $tail")
//
//        println("Is list $this palindroime? ${isPalindrome()}")
//    }


//    var list1 = SinglyLinkedList<Int>()
//    var list2 = SinglyLinkedList<Int>()
//
//    with(list1) {
//        push(6)
//        push(1)
//        push(7)
//
//        println(this)
//        println("Head: $head")
//        println("Tail: $tail")
//
//    }
//
//    with(list2) {
//        push(2)
//        push(9)
//        push(5)
//
//        println(this)
//        println("Head: $head")
//        println("Tail: $tail")
//    }
//
//    val linkedList = addTwoLists2(list1, list2)
//    println("After adding two lists: $linkedList")
//    with(list) {
//        push(2)
//        push(1)
//        push(3)
//        push(5)
//        push(4)
//        append(5)
//        append(4)
//
//        println(list)
//        println("Head: $head")
//        println("Tail: $tail")
////
////        insertAt(0, 5)
////        println("After insert: $list")
////        println("Head: $head")
////        println("Tail: $tail")
////
////        deleteAt(1)
////        println("After delete: $list")
////        println("Head: $head")
////        println("Tail: $tail")
//
//        deDup2()
//        println("After deDup: $list")
//        println("Head: $head")
//        println("Tail: $tail")
//
//
//        val pos = 3
//        var node = getNthFromTail(pos)
//        println("getNthFromTail($pos): $node")
//        println("Head: $head")
//        println("Tail: $tail")
//
//        node = getNthFromTailNoSize(pos)
//        println("getNthFromTailNoSize($pos): $node")
//        println("Head: $head")
//        println("Tail: $tail")
//
//        node = getNthFromTailNoSizeRecursive(pos)
//        println("getNthFromTailNoSizeRecursive($pos): $node")
//        println("Head: $head")
//        println("Tail: $tail")
//
//        val value = 3
//        partitionListAroundValue(value)
//        println("After partitionListAroundValue($value): $list")
//        println("Head: $head")
//        println("Tail: $tail")
//
////        deleteNthNode(3)
////        println("After delete: $list")
////        println("Head: $head")
////        println("Tail: $tail")
//    }

}
