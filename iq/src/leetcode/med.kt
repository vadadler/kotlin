package leetcode

import kotlin.math.pow

// Medium LeetCode problems.

fun main() {
    var l1 = SinglyLinkedList()
    with (l1) {
        push(3)
        push(4)
        push(2)
    }

    var l2 = SinglyLinkedList()
    with (l2) {
        push(4)
        push(6)
        push(5)
    }

    println(addTwoNumbers2(l1, l2))
}

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

2->4->3
5->6->4
-------
7->0->8

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

*/

class DoublyLinedList {
    data class Node(val value: Int, var prev: Node? = null, var next: Node? = null) {
        override fun toString(): String {
            return value.toString()
        }
    }

    var head: Node? = null
    var tail: Node? = null
    var size: Int = 0

    override fun toString(): String {
        var ret = StringBuilder()
        var node = head

        for (i in 1..size) {
            if (i == size) {
                ret?.append(tail?.value)
                break
            }
            ret?.append("$node<-->")
            node = node?.next
        }

        return ret.toString()
    }

    fun push(value: Int) {
        if (size == 0) {
            head = Node(value, null, null)
            tail = head
        } else if (size == 1) {
            tail?.prev = head
            head = Node(value, null, head)
        } else {
            head = Node(value, null, head)
        }

        size++
    }
}

class SinglyLinkedList {
    data class Node(val value: Int, var next: Node?) {
        override fun toString(): String {
            return value.toString()
        }
    }

    var head: Node? = null
    var tail: Node? = null
    var size = 0

    override fun toString(): String {
        var ret = StringBuilder()
        var node = head

        for (i in 1..size) {
            if (i == size) {
                ret.append(node?.value)
            } else {
                ret.append("${node?.value}-->")
            }
            node = node?.next
        }

        return ret.toString()
    }

    fun push(value: Int) {
        var node = Node(value, null)
        if (size == 0) {
            head = node
            tail = head
        } else {
            node.next = head
            head = node
        }

        size++
    }
}

fun addTwoNumbers(l1: SinglyLinkedList?, l2: SinglyLinkedList?): SinglyLinkedList? {
    // Use HashMap to store index, value from the lists.
    var l1HashMap = HashMap<Int, Int?>()
    var l2HashMap = HashMap<Int, Int?>()

    var n1 = l1?.head
    var n2 = l2?.head

    var num1Str = StringBuilder()
    var num2Str = StringBuilder()

    if (l1 != null && l2 != null) {
        for (i in 1..l1.size) {
            l1HashMap.put(i, n1?.value)
            n1 = n1?.next
        }

        for (i in 1..l2.size) {
            l2HashMap.put(i, n2?.value)
            n2 = n2?.next
        }


        for (i in l1.size downTo 1) {
            num1Str.append(l1HashMap.get(i))
        }

        for (i in l2.size downTo 1) {
            num2Str.append(l2HashMap.get(i))
        }

        var num1 = num1Str.toString().toInt()
        var num2 = num2Str.toString().toInt()

        var sum = num1 + num2

        var sumStr = sum.toString()

        var retList = SinglyLinkedList()

        for (i in 0..sumStr.length - 1) {
            retList.push(sumStr.get(i).digitToInt())
        }

        return retList
    }

    return null
}

fun addTwoNumbers2(l1: SinglyLinkedList, l2: SinglyLinkedList): SinglyLinkedList? {
    var node = l1.head
    var n1 = 0
    for (i in 0..l1.size - 1) {
        n1 += node?.value!! * 10.0.pow(i).toInt()
        node = node?.next
    }

    node = l2.head
    var n2 = 0
    for (i in 0..l2.size - 1) {
        n1 += node?.value!! * 10.0.pow(i).toInt()
        node = node?.next
    }

    var sum = n1 + n2

    var l = sum.toString().length
    var num = 0
    var retList = SinglyLinkedList()
    for (i in l - 1 downTo 0) {
        retList.push((sum % 10.0.pow(i + 1).toInt()) / 10.0.pow(i).toInt())
    }

    return retList
}