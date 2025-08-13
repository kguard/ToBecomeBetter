package com.kguard.tobecomebetter.baekjoon

import kotlin.math.max

//실버 1
// 2579 번째와 비슷
// 3잔을 연속으로 마실 수 없기 때문에 케이스 3개로 나눌 수 있음
// 마지막 잔을 안먹는 경우 : n-1 번째 잔 까지 마시는 경우에서 최대 값
// 마지막 잔을 먹는 경우 : n-2 번째 까지 마시는 최대의 경우의 수 + n번째 잔, n-3 번째 까지 마시는 수 + n-1 번째 잔 + n 번째 잔
fun main() {
    val n = readln().toInt()
    val wine = MutableList(n+3){0}
    repeat(n) { wine[it+1] = readln().toInt() }
    val dp = MutableList(n + 3) { 0 }
    dp[1] = wine[1]
    dp[2] = wine[1] + wine[2]
    for (i in 3..n) {
        dp[i] = max( dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i])
        dp[i] = max(dp[i - 1],dp[i])
    }
    println(dp[n])
}