package com.kguard.tobecomebetter.baekjoon

// 브론즈 5
fun main() {
    print(factorial(readln().toInt()))
}

private fun factorial(n: Int): Long {
    return if (n <= 1)
        1
    else
        n * factorial(n - 1)
}