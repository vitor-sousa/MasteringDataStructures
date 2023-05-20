package com.vitorsousa.masteringdatastructures


/**
 * Check if pair with given Sum exists in Array
 */

val array1 = listOf(-6, 0, 9, 2, 5, 7)
val array2 = listOf(6, 4, 3, 2, 1, 7)

fun main(vararg args: String) {
    println(checkPairWithSum(array1, 8))
    println(checkPairWithSum2(array2, 8))
}

// Naive
// O(n^2) - Time Complexity
// O(1) - Space Complexity
fun checkPairWithSum(array: List<Int>, sum: Int): Boolean {
    array.forEachIndexed { index1, item1 ->
        array.forEachIndexed { index2, item2 ->
            if (index1 != index2 && (item1 + item2) == sum) {
                return true
            }
        }
    }
    return false
}

// Best
// O(n) - Time Complexity
// O(n) - Space Complexity
fun checkPairWithSum2(array: List<Int>, sum: Int): Boolean {
    val map = mutableMapOf<Int, Boolean>()
    array.forEach { item ->
        if (map.containsKey(item)) {
            return true
        }
        map[sum - item] = false
    }
    return false
}