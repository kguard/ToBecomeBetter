package com.kguard.tobecomebetter.baekjoon

// 브론즈 4 R2
//수학, 구현, 사칙연산
fun main() {
    val (r1, s) = readln().split(" ").map { it.toInt() }
    println(2 * s - r1)
}