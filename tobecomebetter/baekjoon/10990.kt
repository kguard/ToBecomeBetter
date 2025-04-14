package com.kguard.tobecomebetter.baekjoon

// 브론즈 3 별 찍기 - 15
// 구현
fun main() {
    val n = readln().toInt()
    for (i in 1..n) {
        repeat(n - i) { print(" ") }
        print("*")
        repeat(2 * (i - 1) - 1) { print(" ") }
        if (i > 1) println("*")
        else println()
    }
}