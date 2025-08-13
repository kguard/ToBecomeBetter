package com.kguard.tobecomebetter.baekjoon

// 브론즈 3 별 찍기 - 16
// 구현
fun main() {
    val n = readln().toInt()
    for (i in 1..n) {
        repeat(n - i) { print(" ") }
        if (n == 1) println("*")
        else {
            repeat(i) { print("* ") }
            println()
        }
    }
}