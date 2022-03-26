package puzzles

import datastructures.Stack

/*
 In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different sizes which can slide onto
 any tower. The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sits
 on top of an even larger one).

You have the following constraints:

(1) Only one disk can be moved at a time.
(2) A disk is slid off the top of one tower onto another tower.
(3) A disk cannot be placed on top of a smaller disk.

Write a program to move the disks from the first tower to the last using Stacks.
 */
fun main() {
    var A = Tower() // source
    var B = Tower() // temp
    var C = Tower() // dest
    with (A) {
//        push(5)
//        push(4)
        push(3)
        push(2)
        push(1)
    }

    println(A)
    println(B)
    println(C)

    move(A.size() - 1, A, B)
    A.moveFromTop(C)
    move(B.size() - 1, B, C)
    B.moveFromTop(C)

    println("After rearrange")
    println(A)
    println(B)
    println(C)
}

fun move(num: Int, from: Tower, to: Tower) {
    if (num == 0) return
    to.push(from.pop()!!)
    move(num - 1, from, to)
}

class Tower() {
    var data = Stack<Int>()

    fun moveFromTop(dest: Tower) {
        dest.push(data.pop()!!)
    }

    fun size(): Int {
        return data.length
    }

    fun push(element: Int) {
        data.push(element)
    }

    fun pop(): Int? {
        return data.pop()
    }

    override fun toString(): String {
        return data.toString()
    }
}