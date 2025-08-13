package com.kguard.tobecomebetter.baekjoon

import kotlin.math.pow

// 브론즈 5 검증수
// 수학, 구현, 사칙연산
fun main() {
    val a = readln().split(" ").map { it.toDouble().pow(2) }
    println((a.sum() % 10).toInt())
}