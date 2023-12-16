package com.vitorsousa.masteringdatastructures.binaryTree

class BinarySearchTree() {

    constructor(value: Byte) : this() {
        insertRoot(value)
    }

    private var root: Node? = null

    fun insert(newValue: Byte) {
        if (root == null) {
            insertRoot(newValue)
            return
        }

        val node = searchNode(
            value = newValue,
            returnsPreviousNode = true
        )
        if (newValue > node?.value!!) {
            node.right = Node(newValue)
            return
        }
        node.left = Node(newValue)
    }

    fun lookup(value: Byte) = searchNode(value)

    private fun searchNode(value: Byte, returnsPreviousNode: Boolean = false): Node? {
        var found = false
        var currentNode: Node? = root ?: return null
        var previousNode: Node? = root

        do {
            if(returnsPreviousNode) previousNode = currentNode

            currentNode = if (value > currentNode!!.value) {
                currentNode.right
            } else currentNode.left

            if (currentNode == null) found = true
            if (currentNode?.value == value) found = true

        } while (!found)

        return if(returnsPreviousNode) previousNode else currentNode
    }

    private fun insertRoot(value: Byte) {
        root = Node(value)
    }

    override fun toString(): String {
        return root.toString()
    }
}

fun main(vararg args: String) {
    val binarySearchTree = BinarySearchTree()
    binarySearchTree.insert(10)
    binarySearchTree.insert(4)
    binarySearchTree.insert(15)
    binarySearchTree.insert(2)
    binarySearchTree.insert(23)
    binarySearchTree.insert(6)
    binarySearchTree.insert(12)
    binarySearchTree.insert(3)
    val node = binarySearchTree.lookup(4)
    println(node)
}

