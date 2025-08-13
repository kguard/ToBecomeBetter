package com.kguard.tobecomebetter.baekjoon

import kotlin.math.max

// 골드5
// 냅색 문제(배낭 문제) -> 기본적인 dp 문제
// 총 무게별 과 물건 갯수 별로 가치 구하기 -> ex) 4번째 까지의 물건에서 총 무게가 7일 경우의 최대 가치를 구히기
// 총 무게와 물건의 갯수를 기준으로 2차원 배열 생성
// 내용으로는 가치를 넣음
fun main() {
    val n = readln().split(" ").map { it.toInt() }
    val dp = MutableList(n[0] + 1) { MutableList(n[1] + 1) { 0 } }
    val pack = mutableListOf<Pair<Int, Int>>()
    repeat(n[0]) {
        val t = readln().split(" ").map { it.toInt() }
        pack.add(Pair(t[0], t[1]))
    }
    for (i in 1..n[0]) { // 물건의 순서, 갯수 별로 증가
        for (j in 1..n[1]) { // 총 무게 별로 증가
            val p = pack[i - 1] // 각 물건
            if (j < p.first) // 현재 물건의 무게가 총 무게보다 크면
                dp[i][j] = dp[i - 1][j] // 이전 물건 까지의 가치 받기
            else
                dp[i][j] = max(
                    p.second + dp[i - 1][j - p.first],
                    dp[i - 1][j]
                ) // 이전 물건 까지의 가치와 총 무게에서 물건의 무게를 뺀 부분과 현재의 가치를 더한 것을 비교해서 더 큰 값
        }
    }
    println(dp[n[0]][n[1]])
}