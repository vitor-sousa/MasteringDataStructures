package com.vitorsousa.masteringdatastructures.arrays

/**
 * Create a function that reverse a String
 */

fun main(vararg args: String) {

    val stringToReverse: String = "Hi, reverse this String!"

    println(reverseAString(stringToReverse))
    println(reverseAString2(stringToReverse))

}

// O(n) - Time Complexity
// O(n) - Space Complexity
fun reverseAString(text: String): String {
    var reversed = ""
    for (i in text.length -1 downTo 0) {
        reversed += text[i]
    }
    return reversed
}


// O(n) - Time Complexity ?
// O(1) - Space Complexity ?
fun reverseAString2(text: String): String {
    return text.reversed()
}