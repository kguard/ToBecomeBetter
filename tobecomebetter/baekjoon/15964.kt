package com.kguard.tobecomebetter.baekjoon

// 브론즈 5 이상한 기호
// 수학, 구현, 사칙연산
fun main() {
    val (a, b) = readln().split(" ").map { it.toLong() }
    println((a + b) * (a - b))
}