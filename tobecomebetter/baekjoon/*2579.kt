package com.kguard.tobecomebetter.baekjoon

import kotlin.math.max
// 실버 3
// i 번째 칸에 갈 수 있는 경우의 수는 i + (i-2) 와 i + (i-1) + (i-3)(연속 해서 1칸씩 이동할 수 없어서) 일 경우 이다.
fun main() {
    val n = readln().toInt()
    val list = MutableList(300) { -1 }
    val dp = MutableList(300) { -1 }
    repeat(n) { list[it] = readln().toInt() }
    dp[0] = list[0]
    dp[1] = list[0] + list[1]
    dp[2] = max(list[1] + list[2], list[0] + list[2])
    for (i in 3 until n)
        dp[i] = max(list[i] + dp[i - 2], list[i] + list[i - 1] + dp[i - 3]) // i번쨰 값 + i-2 까지의 합, i번째 값 + i-1 번째 값 + i-3 까지의 합
    println(dp[n-1])
}