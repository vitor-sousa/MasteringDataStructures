package com.vitorsousa.masteringdatastructures.arrays

/**
 * Given an integer array nums, move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 */

fun main(vararg args: String) {

    val nums = arrayListOf(0, 1, 0, 3, 12)
    val nums2 = arrayListOf(0)

    println(moveZeroes(nums))
    println(moveZeroes(nums2))

}

// O(n) - Time Complexity
// O(n) - Space Complexity
fun moveZeroes(array: ArrayList<Int>): List<Int> {
    val finalArray = arrayListOf<Int>()
    var totalZeros = 0

    array.forEach { item ->
        if (item == 0) {
            totalZeros++
        } else {
            finalArray.add(item)
        }
    }

    for (i in 0 until totalZeros) {
        finalArray.add(0)
    }

    return finalArray
}