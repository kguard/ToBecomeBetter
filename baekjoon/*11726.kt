package com.kguard.tobecomebetter.baekjoon

// 실버 3 2xn 타일링
// 다이나믹 프로그래밍(DP)
// 기본적인 dp 문제
// 이전 단계에서 더하는 개념 -> 갯수로는 이전 단계와 같음 
// 이전 단계에서 1X2를 오른쪽에 하나 더한 결과 + 2번 이전 단계(2X1 2개 가능)에서 오른쪽에 2X1를 2개 붙이는 경우를 더하면 됨
fun main() {
    val n = readln().toInt()
    val dp = MutableList(n + 1) { 1L }
    for (i in 2..n) { // 1X2를 오른쪽에 하나 더하는 경우 (한 칸 부족) + 2X1 2개를 오른쪽에 붙이는 경우 (두 칸 부족)
        dp[i] = (dp[i - 1] % 10007+ dp[i - 2] % 10007) % 10007// 모듈러 연산으로 인해서 다 10007를 해야됨
    }
    println(dp[n])
}