package com.kguard.tobecomebetter.baekjoon

import kotlin.math.max

// 실버 3 퇴사
// 다이나믹 프로그래밍(dp), 브루트포스 알고리즘
// 1. i번쨰까지 일했을 떄 얻는 최대 수익
// 2. j는 i번째 날에 상담을 진행했을 떄, "상담이 가능한 모든 날짜" -> i + "상담 기간" 부터 마지막 날 까지
// 3. j를 기준으로 상담을 진행했을 떄 얻는 최대 수익이 dp[j]
fun main() {
    val n = readln().toInt()
    val graph = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph.add(Pair(a, b))
    }
    val dp = MutableList(n+1){0}
    // bottom-up 방식
//    for(i in 0 until n) {
//        for (j in i + graph[i].first .. n)
//            if (dp[j] < dp[i] + graph[i].second)
//                dp[j] = dp[i] + graph[i].second
//
//    }
    // top-down 방식
    for(i in n-1 downTo 0){
        if(i + graph[i].first > n) // n보다 크다는 것은 범위를 벗어나기 때문에 일을 못함
            dp[i] = dp [i+1] // 이전거 계승
        else // 작다는 것은 해당 일을 할 수 있을 경우
            dp[i] = max(dp[i+1], graph[i].second + dp[i + graph[i].first]) // 이전 경우의 수(해당 일을 안했을 경우) 와 해당 일을 했을 경우를 비교해서 문제 해결
    }
    println(dp.max())
}