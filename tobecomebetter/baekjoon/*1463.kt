package com.kguard.tobecomebetter.baekjoon

import kotlin.math.min
// 작은 문제 부터 해결 하여서 문제의 결과를 저장
// 저장한 문제를 이용해서 큰 문제 풀기
// dp 로 풀어야 되기 때문에 숫자의 결과들을 저장
// 에를 들어 10 이면 9에서 +1을 더한 것
fun main() {
    val n = readln().toInt()
    val dp = MutableList(n + 2) { 0 }
    for (i in 2..n) {
        dp[i] = dp[i - 1] + 1
        if (i % 2 == 0)
            dp[i] = min(dp[i], dp[i / 2] + 1)
        if (i % 3 == 0)
            dp[i] = min(dp[i], dp[i / 3] + 1)
    }
    print(dp[n])
}