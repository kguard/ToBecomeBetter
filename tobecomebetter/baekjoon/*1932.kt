package com.kguard.tobecomebetter.baekjoon

import kotlin.math.max
// 실버 1
// 이전 값과 비교해서 다음 값 더하기
fun main() {
    val n = readln().toInt()
    val dp = mutableListOf<MutableList<Int>>()
    val sums = MutableList(n) { MutableList(500) { -1 } }
    repeat(n) {
        dp.add(readln().split(" ").map { it.toInt() }.toMutableList())
    }
    sums[0] = dp[0]
    for (i in 1 until n) {
        for (j in 0..i) {
            when (j) {
                0 -> sums[i][j] = dp[i][j] + sums[i - 1][j]
                i -> sums[i][j] = dp[i][j] + sums[i - 1][j - 1]
                else -> sums[i][j] = max(sums[i - 1][j], sums[i - 1][j - 1]) + dp[i][j]
            }
        }
    }
    println(sums[n-1].max())
}