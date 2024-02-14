package com.kguard.tobecomebetter.baekjoon
//브론즈 2
fun main() {
    print(fibonacci(readln().toInt()))
}

private fun fibonacci(n: Int): Int {
    return if (n <= 1) n else fibonacci(n - 1) + fibonacci(n - 2)
}