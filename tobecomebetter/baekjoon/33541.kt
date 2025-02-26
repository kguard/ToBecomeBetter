package com.kguard.tobecomebetter.baekjoon

import kotlin.math.pow

// 브론즈 3 2025는 무엇이 특별할까?
// 수학, 브루트포스 알고리즘
fun main() {
    var n = readln().toInt() + 1
    while (n < 10000) {
        val a = n / 100
        val b = n % 100
        if ((a + b).toDouble().pow(2).toInt() == n) {
            println(n)
            return
        }
        else
            n++
    }
    println(-1)
}