package com.kguard.tobecomebetter.baekjoon

// 브론즈 3 웰컴 키트
// 수학, 구현, 사칙연산
fun main() {
    val n = readln().toInt()
    val size = readln().split(" ").map { it.toInt() }
    val (t, p) = readln().split(" ").map { it.toInt() }
    var tSum = 0
    size.forEach {
        tSum += if (it % t == 0)
            it / t
        else
            it / t + 1
    }
    println(tSum)
    print("${n / p} ${n % p}")
}