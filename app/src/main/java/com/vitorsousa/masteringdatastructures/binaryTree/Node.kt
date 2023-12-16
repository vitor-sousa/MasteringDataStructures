package com.vitorsousa.masteringdatastructures.binaryTree

data class Node(val value: Int) {
    var left: Node? = null
    var right: Node? = null
    override fun toString(): String {
        return value.toString()
    }
}