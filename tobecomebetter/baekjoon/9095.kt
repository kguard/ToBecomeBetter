package com.kguard.tobecomebetter.baekjoon

// 실버 3 1, 2, 3 더하기
// 다이나믹 프로그래밍(dp)
// 각 숫자를 만드는 경우의 수는 n-1단계에 있는 조합에서 +1 한 경우, n-2단계 조합에서 +2 한 경우, n-3단계 조합에서 +3 한 경우
// 그래서 (n-1)+(n-2)+(n-3)를 더해주면 됨
fun main() {
    val t = readln().toInt()
    val dp = MutableList(12) { 0 }
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4
    for (i in 4..11)
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
    repeat(t) {
        val n = readln().toInt()
        println(dp[n])
    }
}