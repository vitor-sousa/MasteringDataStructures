package com.vitorsousa.masteringdatastructures.binaryTree

class BinarySearchTree() {

    constructor(value: Int) : this() {
        insertRoot(value)
    }

    private var root: Node? = null

    fun insert(newValue: Int) {
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

    fun lookup(value: Int) = searchNode(value)

    private fun searchNode(value: Int, returnsPreviousNode: Boolean = false): Node? {
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

    private fun insertRoot(value: Int) {
        root = Node(value)
    }

    override fun toString() = diagram(root)

    private fun diagram(node: Node?,
                        top: String = "",
                        root: String = "",
                        bottom: String = ""): String {
        return node?.let {
            if (node.left == null && node.right == null) {
                "$root${node.value}\n"
            } else {
                diagram(node.right, "$top ", "$top┌──", "$top│ ") +
                        root + "${node.value}\n" + diagram(node.left, "$bottom│ ", "$bottom└──", "$bottom ")
            }
        } ?: "${root}null\n"
    }

}

fun main(vararg args: String) {
    val binarySearchTree = BinarySearchTree()
    binarySearchTree.insert(9)
    binarySearchTree.insert(4)
    binarySearchTree.insert(6)
    binarySearchTree.insert(20)
    binarySearchTree.insert(170)
    binarySearchTree.insert(15)
    binarySearchTree.insert(1)
    println(binarySearchTree.toString())
}

