package com.kguard.tobecomebetter.baekjoon

import java.math.BigInteger

// 실버 5 피보나치 수 4
// 다이나믹 프로그래밍, 임의 정밀도 / 큰 수 연산
// n이 10000까지이기 때문에 피보나치값이 long을 넘기 때문에 BigInteger로 해결
fun main(){
    val n = readln().toInt()
    val dp = mutableListOf<BigInteger>()
    dp.add(0.toBigInteger())
    dp.add(1.toBigInteger())
    for(i in 2..n)
        dp.add(dp[i-1] + dp[i-2])
    println(dp[n])
}