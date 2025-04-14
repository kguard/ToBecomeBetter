package com.kguard.tobecomebetter.baekjoon

// 브론즈 5 크냐?
// 구현
fun main() {
    while (true) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        if (a == 0 && b == 0) break
        if (a > b) println("Yes") else println("No")
    }
}