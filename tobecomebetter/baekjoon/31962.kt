package com.kguard.tobecomebetter.baekjoon

import kotlin.math.max

// 브론즈 4 등교
// 수학, 구현, 사칙연산
fun main() {
    val (n, x) = readln().split(" ").map { it.toInt() }
    var max = -1
    repeat(n) {
        val (s, t) = readln().split(" ").map { it.toInt() }
        if (s + t <= x)
            max = max(max,s)
    }
    print(max)
}