package com.kguard.tobecomebetter.baekjoon

// 브론즈 3 별 찍기 - 6
// 구현
fun main() {
    val n = readln().toInt()
    for (i in n downTo 1) {
        repeat(n - i) { print(" ") }
        repeat(2 * i - 1) { print("*") }
        println(" ")
    }
}