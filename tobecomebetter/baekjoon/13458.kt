package com.kguard.tobecomebetter.baekjoon

// 브론즈 2 시험 감독
// 수학, 사칙연산
fun main() {
    val n = readln().toLong()
    val a = readln().split(" ").map { it.toLong() }
    val (b, c) = readln().split(" ").map { it.toLong() }
    var sum = a.size.toLong()
    for (i in a.map { it - b }) {
        if (i <= 0) continue // 적을수ㄷ
        sum += if (i % c == 0L)
            i / c
        else
            (i / c + 1)
    }
    println(sum)
}