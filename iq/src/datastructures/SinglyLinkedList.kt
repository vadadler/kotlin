package datastructures

import leetcode.addTwoNumbers3
import java.lang.Math.abs
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

    override fun toString(): String {
        var ret = StringBuilder()
        var node = head

        while (node != null) {
            if (node.next == null) {
                print(node.value)
            } else {
                print("${node.value}-->")
            }
            node = node.next
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

    fun getAtPosRecursive(node: Node<Int>, pos: Int, currentPos: Int): Node<Int>? {
        if (node == null) return null
        if (pos == currentPos) return node
        return getAtPosRecursive(node.next!!, pos, currentPos + 1)
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

    // Use two pointers: slow (1 step at a time) and fast (2 steps at a time)
    // When two points meet, next node is the beginning of the loop.
    fun circularNodeTwoPointers(slow: Node<Int>, fast: Node<Int>): Node<Int>? {
        if (slow?.next == null || fast?.next?.next == null) return null
        if (slow == fast) return slow.next
        var node = circularNodeTwoPointers(slow?.next!!, fast?.next?.next!!)
        return node
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

// Lists are the same length.
// Two numbers represented as SLL where each node contains single digit. The digits are stored in reverse order.
// Example:
// Input: (7->1->6) + (5->9->2) That is 617+295
// Output: 2->1->9 That is, 912
fun addTwoLists3(n1: SinglyLinkedList.Node<Int>?, n2: SinglyLinkedList.Node<Int>?, more: Int): SinglyLinkedList.Node<Int>? {
    if (n1 == null && n2 == null) {
        if (more != 0) {
          return SinglyLinkedList.Node(more, null)
        } else return null
    }

    var sum1 = 0
    var sum2 = 0
    var sum = 0
    var more = 0

    if (n1 != null) {
        sum1 = n1.value
    }

    if (n2 != null) {
        sum2 = n2.value
    }

    sum = sum1 + sum2

    if (sum >= 10) {
        more = 1
        sum = sum % 10
    }

    var result = SinglyLinkedList.Node(sum, null)

    result.next = addTwoLists3(n1?.next, n2?.next, more)

    return result
}

// Lists are the same length.
// Two numbers represented as SLL where each node contains single digit.
// Example:
// Input: (7->1->6) + (5->9->2) That is 716+592
// Output: 1->3->0->8 That is, 1308
fun addTwoLists4(n1: SinglyLinkedList.Node<Int>?, n2: SinglyLinkedList.Node<Int>?, prevNode: SinglyLinkedList.Node<Int>?): SinglyLinkedList.Node<Int>? {
    if (n1 == null && n2 == null) return null

    var sum1 = 0
    var sum2 = 0
    if (n1 != null) {
        sum1 = n1.value
    }

    if (n2 != null) {
        sum2 = n2.value
    }
    var sum = sum1 + sum2
    val value = sum % 10
    var more = 0
    if (sum >= 10) prevNode?.value = prevNode?.value?.plus(1)!!

    var result = SinglyLinkedList.Node(value, null)

    result?.next = addTwoLists4(n1?.next, n2?.next, result)

    return result
}

// Lists are not the same length.
// Two numbers represented as SLL where each node contains single digit.
// Example:
// Input: (7->1->6) + (8->5->9->2) That is 716+8292
// Output: 8->7->0->8 That is, 1308
fun addTwoLists5(l1: SinglyLinkedList<Int>, l2: SinglyLinkedList<Int>):SinglyLinkedList.Node<Int>? {
    // Prepad shorter list with 0 nodes.
    val numZeros = l1.size - l2.size
    if (numZeros != 0) {
        var tempList = SinglyLinkedList<Int>()
        if (numZeros > 0) { // l1 is lengthier then l2
            tempList = l2
        } else {
            tempList = l1
        }

        for (i in 1..abs(numZeros)) {
            var tempNode = SinglyLinkedList.Node<Int>(0, null)
            tempNode.next = tempList.head
            tempList.head = tempNode
            tempList.size++
        }
    }

    println(l1)
    println(l2)

    var prevNode = SinglyLinkedList.Node(0, null)
    var node = addTwoLists4(l1.head, l2.head, prevNode)

    if (node?.value!! >= 10) {
        var tempNode = SinglyLinkedList.Node(1, node)
        node?.value = node?.value!! % 10
        tempNode.next = node
        return tempNode
    }

    return node
}

fun addDigits(num: Int): Int {
    val chNum = num.toString().toCharArray()

    if (chNum.size == 1) return chNum[0].digitToInt()

    var sum = 0
    for(i in 0..chNum.size - 1) {
        sum += chNum[i].digitToInt()
    }

    return addDigits(sum)
}

fun main() {
    var list1 = SinglyLinkedList<Int>()
    var list2 = SinglyLinkedList<Int>()

    with(list1) {
        push(6)
        push(5)
        push(4)
        push(3)
        push(2)
        push(1)

        tail?.next = head?.next?.next
    }

    val node = list1.circularNodeTwoPointers(list1?.head?.next!!, list1?.head?.next?.next!!)
    println(node)
}
