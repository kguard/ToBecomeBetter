package com.kguard.tobecomebetter.baekjoon
// 브론즈 5
fun main() {
    print(factorialP(readln().toInt()))
}

private fun factorialP(n: Int): Long {
    return if (n <= 1)
        1
    else
        n * factorialP(n - 1)
}