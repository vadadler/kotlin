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
    var source = Stack<Int>()
    var temp = Stack<Int>()
    var dest = Stack<Int>()
    with (source) {
        //     push(3)
        push(2)
        push(1)
    }

    println(source)
    println(temp)
    println(dest)

    rearrange(source, dest, temp)

    println(source)
    println(temp)
    println(dest)
}

fun rearrange(src: Stack<Int>, tmp: Stack<Int>, dest: Stack<Int>) {
    if (src == null) return

    if (src.length == 1) {
        dest.push(src.pop()!!)
    }

    rearrange(src, tmp, dest)
}