package com.vitorsousa.masteringdatastructures.graph

import java.io.StringWriter

class UndirectedGraph<T> {
    private var numberOfNodes = 0
    private val adjacentList = mutableListOf<Pair<T, MutableList<T>>>()

    fun addVertex(value: T) {
        numberOfNodes++
        adjacentList.add(Pair(value, mutableListOf()))
    }
    fun addEdge(value: T, node: T) {
        adjacentList.find { it.first == value }?.apply {
            this.second.add(node)
        }
        adjacentList.find { it.first == node }?.apply {
            this.second.add(value)
        }
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        adjacentList.forEach {
            stringBuilder.appendLine("${it.first} --> ${it.second}")
        }
        return stringBuilder.toString()
    }
}

fun main() {
    val undirectedGraph = UndirectedGraph<Int>()
    undirectedGraph.addVertex(0)
    undirectedGraph.addVertex(1)
    undirectedGraph.addVertex(2)
    undirectedGraph.addVertex(3)
    undirectedGraph.addVertex(4)
    undirectedGraph.addVertex(5)
    undirectedGraph.addVertex(6)

    undirectedGraph.addEdge(3, 1)
    undirectedGraph.addEdge(3, 4)
    undirectedGraph.addEdge(4, 2)
    undirectedGraph.addEdge(4, 5)
    undirectedGraph.addEdge(1, 2)
    undirectedGraph.addEdge(1, 0)
    undirectedGraph.addEdge(0, 2)
    undirectedGraph.addEdge(6, 5)
    println(undirectedGraph.toString())
}