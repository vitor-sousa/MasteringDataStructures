package com.vitorsousa.masteringdatastructures.stack

class Stack<T> {
    private var top: Node<T>? = null
    private var bottom: Node<T>? = null
    private var length = 0

    override fun toString(): String {
        return top.toString()
    }

    fun isEmpty() = length == 0

    fun push(value: T): Stack<T> {
        val newValue = Node(value)
        if (isEmpty()) {
            top = newValue
            bottom = newValue
        } else {
            val holding = top
            top = newValue
            top?.next = holding
        }
        length++
        return this
    }

    fun pop() {
        if (isEmpty()) {
            if(top == bottom) {
                bottom = null
            }
            top = top?.next
            length--
        }
    }
}

data class Node<T>(var value: T, var next: Node<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }

    }
}

fun main(vararg args: String) {

    val stack = Stack<Int>()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.pop()
    println(stack.toString())
}

