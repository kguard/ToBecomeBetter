package com.kguard.tobecomebetter.baekjoon

import kotlin.math.min

// 브론즈 3 3대 512
// 수학, 구현, 사칙연산
fun main() {
    val n = readln().toInt()
    var min = 601
    repeat(n) {
        val sum = readln().split(" ").sumOf { it.toInt() }
        if (sum >= 512)
            min = min(min, sum)
    }
    if (min == 601)
        min = -1
    println(min)
}