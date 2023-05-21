package com.vitorsousa.masteringdatastructures.arrays

/**
 * Given 2 arrays that are sorted, merge them into 1 array sorted
 */

fun main(vararg args: String) {

    val array1 = arrayListOf(0, 3, 4, 31)
    val array2 = arrayListOf(4, 6, 30)

    println(mergeSortedArrays(array1, array2))

}

fun mergeSortedArrays(
    array1: ArrayList<Int>,
    array2: ArrayList<Int>
): List<Int> {
    val finalSortedArray = arrayListOf<Int>()
    finalSortedArray.addAll(array1)
    finalSortedArray.addAll(array2)
    return finalSortedArray.sorted()
}