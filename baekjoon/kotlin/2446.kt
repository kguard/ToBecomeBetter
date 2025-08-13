package com.kguard.tobecomebetter.baekjoon

// 브론즈 3 별 찍기 - 9
// 구현
fun main() {
    val n = readln().toInt()
    for (i in 1..2 * n - 1) {
        if (i <= n) {
            repeat(i - 1) { print(" ") }
            repeat(2 * n - (2 * i - 1)) { print("*") }
            println()
        } else {
            repeat(2 * n - i - 1) { print(" ") }
            repeat(2 * i - (2 * n - 1)) { print("*") }
            println()
        }
    }
}