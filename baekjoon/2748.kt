package com.kguard.tobecomebetter.baekjoon
// 브론즈 1 피보나치 수 2
// 수학, 다이나믹 프로그래밍(dp)
// 90까지 이기 때문에 Long 타입으로 문제 해결
fun main(){
    val n = readln().toInt()
    val dp = MutableList(91){0L}
    dp[1] = 1L
    for(i in 2..90)
        dp[i] = dp[i-1] + dp[i-2]
    println(dp[n])
}