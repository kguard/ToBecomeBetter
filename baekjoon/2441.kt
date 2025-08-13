package com.kguard.tobecomebetter.baekjoon

// 브론즈 3 별 찍기 - 4
// 구현
fun main() {
    val n = readln().toInt()
    for (i in 0..n) {
        repeat(i) {
            print(" ")
        }
        repeat(n-i) {
            print("*")
        }
        println()
    }
}