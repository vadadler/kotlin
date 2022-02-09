package datastructures

class DoublyLinkedList {
    data class Node<Int>(var value: Int, var prev: Node<Int>?, var next: Node<Int>?) {
        override fun toString(): String {
            return super.toString()
        }
    }

    var head: Node<Int>? = null

}