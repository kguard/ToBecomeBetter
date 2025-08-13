package com.kguard.tobecomebetter.baekjoon

// 블랙 0 별 찍기 - 14
// 구현
fun main() {
    val n = readln().toInt()
    repeat(n) {
        repeat(n) { print("*") }
        println()
    }
}