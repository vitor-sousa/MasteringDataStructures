package com.vitorsousa.masteringdatastructures.binaryTree

class BinarySearchTree() {

    constructor(value: Int) : this() {
        insertRoot(value)
    }

    private var root: Node? = null

    fun lookup(value: Int) = searchNode(value)

    fun insert(newValue: Int) {
        if (root == null) {
            insertRoot(newValue)
            return
        }

        val node = searchNode(
            value = newValue,
            returnsParent = true
        )
        if (newValue > node?.value!!) {
            node.right = Node(newValue)
            return
        }
        node.left = Node(newValue)
    }

    fun remove(value: Int) {
        if (root == null) return

        val parent = searchNode(value, true)
        val node = searchNode(value)

        if (node?.left == null && node?.right == null) {
            removeNoChildNode(node, parent)
            return
        }
        if (node.left != null && node.right != null) {
            removeTwoChildNode(node)
            return
        }
        removeOneChildNode(node, parent)
    }

    private fun removeNoChildNode(node: Node?, parent: Node?) {
        if (node?.value == parent?.left?.value) {
            parent?.left = null
            return
        }
        parent?.right = null
    }

    private fun removeOneChildNode(node: Node, parent: Node?) {
        val child: Node? = node.left ?: node.right
        if (node.value == parent?.left?.value) {
            parent.left = child
            return
        }
        parent?.right = child
    }

    private fun removeTwoChildNode(node: Node) {
        var currentNode = node.right

        do {
            if (currentNode?.left != null) currentNode = currentNode.left
        } while (currentNode?.left != null)

        val parentCurrentNode = searchNode(currentNode!!.value, true)

        if (node.value == root?.value) {
            node.value = currentNode.value
            parentCurrentNode?.left = currentNode.right
        } else {
            parentCurrentNode?.value = currentNode.value
            parentCurrentNode?.right = null
        }
    }

    private fun searchNode(
        value: Int,
        returnsParent: Boolean = false
    ): Node? {
        if (value == root?.value) return root

        var found = false
        var currentNode: Node? = root ?: return null
        var parentNode: Node? = root

        do {
            if(returnsParent) parentNode = currentNode

            currentNode = if (value > currentNode!!.value) {
                currentNode.right
            } else currentNode.left

            if (currentNode == null) found = true
            if (currentNode?.value == value) found = true

        } while (!found)

        return if(returnsParent) parentNode else currentNode
    }

    private fun insertRoot(value: Int) {
        root = Node(value)
    }

    override fun toString() = diagram(root)

    private fun diagram(
        node: Node?,
        top: String = "",
        root: String = "",
        bottom: String = ""
    ): String {
        return node?.let {
            if (node.left == null && node.right == null) {
                "$root${node.value}\n"
            } else {
                diagram(node.right, "$top ", "$top┌──", "$top│ ") + root + "${node.value}\n" + diagram(node.left, "$bottom│ ", "$bottom└──", "$bottom ")
            }
        } ?: "${root}null\n"
    }
}

fun main(vararg args: String) {
    val binarySearchTree = BinarySearchTree()
    binarySearchTree.insert(5)
    binarySearchTree.insert(3)
    binarySearchTree.insert(8)
    binarySearchTree.insert(2)
    binarySearchTree.insert(4)
    binarySearchTree.insert(6)
    binarySearchTree.insert(9)
    binarySearchTree.insert(7)
    println(binarySearchTree.toString())
    binarySearchTree.remove(5)
    println(binarySearchTree.toString())
}

