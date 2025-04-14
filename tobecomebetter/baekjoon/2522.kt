package com.kguard.tobecomebetter.baekjoon

// 브론즈 3 별 찍기 - 12
// 구현
fun main() {
    val n = readln().toInt()
    for (i in 1..2 * n - 1) {
        if (i <= n) {
            repeat(n - i) { print(" ") }
            repeat(i) { print("*") }
            println()
        } else {
            repeat(i - n) { print(" ") }
            repeat(2 * n - i) { print("*") }
            println()
        }
    }
}