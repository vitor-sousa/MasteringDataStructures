package com.vitorsousa.masteringdatastructures.arrays

/**
 * First Recurring Character
 * Given a array, return the first recurring character
 */

fun main(vararg args: String) {

    val array1 = arrayListOf(2, 1, 1, 2, 3, 5, 1, 2, 4)
    println(getFirstRecurring(array1))

}

// O(n) - Time Complexity
// O(n) - Space Complexity
fun <T> getFirstRecurring(nums: List<T>): T? {
    val itemsSet = mutableSetOf<T>()

    nums.forEach { item ->
        if (itemsSet.contains(item)) {
            return item
        }
        itemsSet.add(item)
    }

    return null
}

