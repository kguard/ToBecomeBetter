package com.kguard.tobecomebetter.baekjoon

import kotlin.math.min

// 골드 4 호텔
// 다이나믹 프로그래밍, 배낭 문제
// 일반 적인 배낭 문제는 2차원 배열로 짐의 갯수가 들어가는  행, 각 무게가 들어갈 열 이렇게 2차원 배열로 구성
// 이 문제는 1차원 배열로 인덱스는 고객 수가 들어가고, dp[i]에는 최소 비용이 들어가게 됨
fun main() {
    val (c, n) = readln().split(" ").map { it.toInt() }
    val dp = MutableList(c + 101) { 1000001 }
    dp[0] = 0
    repeat(n) {
        val (a, b) = readln().split(" ").map { it.toInt() } // a는 비용, b는 사람
        for (j in b until dp.size) // b 부터 c+100 까지
            dp[j] = min(dp[j], dp[j - b] + a) // 원래 있는 값이 랑 원래 인원수 - b 에 추가되는 a 값을 비교
    }
    println(dp)
    print(dp.slice(c until dp.size - 1).min()) // c 부터 끝까지 중 최소 값을 구하면 됨 -> c 보다 많아도 더 작으면 그 값을 고르면 됨
}