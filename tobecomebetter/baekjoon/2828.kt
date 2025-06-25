package com.kguard.tobecomebetter.baekjoon

import kotlin.math.abs

// 실버 5 사과 담기 게임
// 구현, 그리디 알고리즘
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val j = readln().toInt()
    var count = 0
    var now = MutableList(m) { it + 1 }
    repeat(j) {
        val t = readln().toInt()
        val move = if (t in now)
            0
        else if (t > now.max())
            now.minOf { t - it }
        else
            now.maxOf { t - it }

        count += abs(move)
        now.replaceAll { it + move }

    }
    println(count)
}