package com.vitorsousa.masteringdatastructures.binaryTree

data class Node(var value: Int) {
    var left: Node? = null
    var right: Node? = null
    override fun toString(): String {
        return value.toString()
    }
}