package com.kguard.tobecomebetter.baekjoon

import kotlin.math.pow

// 브론즈 3 직각삼각형
// 수학, 기하학, 피타고라스 정리
fun main() {
    while (true) {
        val a = readln().split(" ").map { it.toDouble() }.sorted()
        if (a[0] == 0.0 && a[1] == 0.0 && a[0] == 0.0) return
        if (a[0].pow(2) + a[1].pow(2) == a[2].pow(2))
            println("right")
        else
            println("wrong")
    }
}