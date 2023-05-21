package com.vitorsousa.masteringdatastructures.arrays

/**
 * Longest Word
 * Have the function LongestWord(sen) take the sen parameter being passed and return the longest word in the string.
 * If there are two or more words that are the same length, return the first word from the string with that length.
 * Ignore punctuation and assume sen will not be empty. Words may also contain numbers, for example "Hello world123 567"
 */

fun main(vararg args: String) {

    val text = "fun&!! time test"
    println(longestWord2(text))

}

// O(n) - Time Complexity
// O(n) - Space Complexity
fun longestWord(text: String): String {
    val regex = Regex("[^A-Za-z0-9 ]")
    val longestMap = mutableMapOf<Int, String>()

    text.replace(regex, "").split(" ").forEach { word ->
        longestMap[word.length] = word
    }

    return longestMap[longestMap.maxOf { it.key }] ?: ""
}

// O(n) - Time Complexity
// O(1) - Space Complexity
fun longestWord2(text: String): String {
    val regex = Regex("[^A-Za-z0-9 ]")
    var mostLongWord = ""

    text.replace(regex, "").split(" ").forEach { word ->
        if (mostLongWord.length < word.length) {
            mostLongWord = word
        }
    }

    return mostLongWord
}