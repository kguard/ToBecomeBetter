package com.kguard.tobecomebetter.baekjoon

// 브론즈 3 별 찍기 - 8
// 구현
fun main() {
    val n = readln().toInt()
    for (i in 1..2 * n - 1) {
        if (i <= n) {
            repeat(i) { print("*") }
            repeat(2 * n - 2 * i) { print(" ") }
            repeat(i) { print("*") }
            println()
        } else {
            repeat(2 * n - i) { print("*") }
            repeat(2 * i - 2 * n) { print(" ") }
            repeat(2 * n - i) { print("*") }
            println()
        }
    }
}