package com.vitorsousa.masteringdatastructures.linkedList

data class Node<T>(var value: T, var next: Node<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }
}

class LinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var length = 0

    override fun toString(): String {
        return head.toString()
    }

    fun isEmpty(): Boolean = length == 0

    fun append(value: T) {
        if (isEmpty()) {
            push(value)
            return
        }
        tail?.next = Node(value)
        length++
    }

    fun push(value: T): LinkedList<T> {
        head = Node(value, head)
        if (tail == null) {
            tail = head
        }
        length++
        return this
    }

    fun removeAfter(node: Node<T>?): LinkedList<T> {
        if (node?.next == tail) {
            tail = node
        }
        if (node?.next != null) {
            length--
        }
        node?.next = node?.next?.next
        return this
    }

    fun nodeAt(index: Int): Node<T>? {
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index - 1) {
            currentNode = currentNode.next
            currentIndex++
        }

        return currentNode
    }

    fun reverse(): LinkedList<T> {
        if (length < 2) return this

        var first = head
        tail = head
        var second = head?.next

        while (second != null) {
            var temp = second.next
            second.next = first
            first = second
            second = temp
        }
        head?.next = null
        head = first
        return this
    }

}


fun main(vararg args: String) {

    val linkedList = LinkedList<Int>()

    linkedList.push(3).push(2).push(1)

    linkedList.append(4)

    linkedList.removeAfter(linkedList.nodeAt(2))

    linkedList.reverse()

    println(linkedList.toString())
}
