package com.vitorsousa.masteringdatastructures.arrays

/**
 * Merge Strings Alternately
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1.
 * If a string is longer than the other, append the additional letters onto the end of the merged string. Return the merged string.
 */

fun main(vararg args: String) {

    val word1 = "abc"
    val word2 = "pqr"

    println(mergeTwoStrings(word1, word2))
}

fun mergeTwoStrings(string1: String, string2: String): String {
    val stringBuilder = StringBuilder()
    var currentIndex = 0

    if (string1.isEmpty()) return string2
    if (string2.isEmpty()) return string1

    string1.forEachIndexed { index, char ->
        stringBuilder.append(char)
        if (index < string2.length) {
            stringBuilder.append(string2[index])
            currentIndex++
        }
    }

    while (currentIndex < string2.length) {
        stringBuilder.append(string2[currentIndex])
        currentIndex++
    }

    return stringBuilder.toString()
}