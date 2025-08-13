package com.kguard.tobecomebetter.baekjoon

import kotlin.math.min

// 브론즈 4 빵
// 구현
fun main() {
    val n = readln().toInt()
    var min = 2000
    repeat(n) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        if (a <= b)
            min = min(min, b)
    }
    if (min == 2000)
        min = -1
    print(min)
}