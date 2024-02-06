package com.vitorsousa.masteringdatastructures.recursion

import java.math.BigInteger

fun main() {
    val number = 8
    println(findFactorialRecursive(number))
    println(findFactorialIterative(number))

    println(fibonacciIterative(8))
    println(fibonacciRecursive(8))

    println(reverseStringRecursive("yoyo master"))
}

fun findFactorialRecursive(value: Int): Int {
    return if (value == 0) 1 else value * findFactorialRecursive(value - 1)
}

fun findFactorialIterative(value: Int): Int {
    var total = value
    for (i in value downTo 2) {
        total *= (i - 1)
    }
    return total
}

fun fibonacciIterative(n: Int): BigInteger { // O(n)
    val fibonacci = mutableListOf(BigInteger.ZERO, BigInteger.ONE)
    for (i in 2..n) {
        fibonacci.add((fibonacci[i - 2]) + (fibonacci[i - 1]))
    }
    return fibonacci[n]
}

fun fibonacciRecursive(n: Int): BigInteger { // O(2^n)
    if (n < 2) return BigInteger.valueOf(n.toLong())
    return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2)
}

fun reverseStringRecursive(text: String): String {
    return if (text == "") return "" else reverseStringRecursive(text.substring(1)) + text[0]
}