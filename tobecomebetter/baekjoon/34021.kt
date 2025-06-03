package com.kguard.tobecomebetter.baekjoon

import kotlin.math.max

// 브론즈 3 [T] 스코어보드가 121분 남은 시점에서 프리즈되었습니다.
// 수학, 구현, 사칙연산
fun main() {
    repeat(readln().toInt()) {
        val (n, m, l) = readln().split(" ").map { it.toInt() }
        val times = readln().split(" ").map { it.toInt() }.toMutableList()
        times.removeAll { it == -1 }
        var min = l
        if (times.isNotEmpty())
            min = max(m - times.min(), l)
        if (min == 1)
            println("The scoreboard has been frozen with $min minute remaining.")
        else
            println("The scoreboard has been frozen with $min minutes remaining.")
    }
}