package com.kguard.tobecomebetter.baekjoon

import kotlin.math.min

// 실버 1 1로 만들기 2
// 다이나믹 프로그래밍, 그래프 이론, 그래프 탐색
// 역으로 해결
// 1차원 dp로 문제 해결 -> 1부터 시작해서 문제 해결
fun main() {
    val n = readln().toInt()
    val dp = mutableListOf<Int>()
    for (i in 0..n)
        dp.add(i)
    for (i in 2..n) {
        dp[i] = dp[i - 1] + 1 // 1을 빼는 경우
        if (i % 3 == 0) // 3으로 나누어 떨어지면 3으로 떨어진 dp +1
            dp[i] = min(dp[i], dp[i / 3] + 1)
        if (i % 2 == 0) // 2으로 나누어 떨어지면 2로 떨어진 dp +1
            dp[i] = min(dp[i], dp[i / 2] + 1)
    }
    println(dp[n]-1)
    var c = n
    print("$c ")
    while (c > 1) {
        if (c % 3 == 0 && dp[c] == dp[c / 3] + 1) {
            c /= 3
            print("$c ")
        } else if (c % 2 == 0 && dp[c] == dp[c / 2] + 1) {
            c /= 2
            print("$c ")
        } else {
            c--
            print("$c ")
        }
    }
}