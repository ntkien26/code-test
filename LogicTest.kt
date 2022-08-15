package com.moewsoft.newsapp

fun main() {
    val input = arrayOf(1,3,5,7,9)
    if (getMiddleIndex(input) != -1) {
        println("Middle index is ${getMiddleIndex(input)}")
    }

    val word = "level"
    if (isPalindromeString(word)) {
        println("$word is a palindrome")
    } else {
        println("$word isn't a palindrome")
    }
}

fun getMiddleIndex(inputArr: Array<Int>): Int {
    for (i in 1 until inputArr.size) {
        var leftSum = 0

        for (j in i-1 downTo 0 step 1) {
            leftSum += inputArr[j]
        }

        var rightSum = 0

        for (k in i+1 until inputArr.size) {
            rightSum += inputArr[k]
        }

        if (leftSum == rightSum) {
            return i
        }
    }
    return -1
}

fun isPalindromeString(inputStr: String): Boolean {
    var i = 0
    var j = inputStr.length - 1

    while (i < j) {
        if (inputStr[i] != inputStr[j]) {
            return false
        }
        i++
        j--
    }
    return true
}