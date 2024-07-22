package com.kguard.tobecomebetter.baekjoon

import kotlin.math.*

// 플레티넘 4 경찰차
// 다이나믹 프로그래밍(dp)
// dfs + dp 로 해결
// 어렵기 때문에 나중에 확인 필요!!!
// 두 경찰차의 이동 거리의 합이 최소거리여야 함
// dp가 각 가로 세로가 경찰차가 해결한 사건을 뜻하고, 안에 있는 값이 해결한 사건 번호까지의 최소값
// 최소값이 재귀로 동작하기 때문에 거꾸로 저장됨
fun main() {
    val n = readln().toInt()
    val w = readln().toInt()
    val case = mutableListOf<Pair<Int, Int>>()
    case.add(Pair(0,0))
    repeat(w) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        case.add(Pair(a, b))
    }
    val dp = MutableList(1001){MutableList(1001){-1}} // dp[p1][p2] = a -> p1이 마지막으로 해결한 사건의 번호 와 p2가 마지막으로 해결한 사전의 번호까지의 최소값 a
    fun distance(fx: Int, fy: Int, sx: Int, sy: Int): Int = abs(fx - sx) + abs(fy - sy)

    fun totalDistance(p1: Int, p2: Int): Int { // 총 이동한 거리의 최소 값
        if(p1 == w || p2 == w) return 0
        if(dp[p1][p2] != -1) return dp[p1][p2]
        val next = max(p1,p2) + 1 // 다음 사건 번호
        // p1 == 0 이면 -> p1이 해결한 사건이 없으면, 1,1 에서 시작 아니면 해결한 사건 번호의 위치에서 시작
        val dis1 = if (p1 == 0) distance(1,1,case[next].first,case[next].second) else distance(case[p1].first,case[p1].second,case[next].first,case[next].second)
        // p2 == 0 이면 -> p2가 해결한 사건이 없으면, n,n 에서 시작 아니면 해결한 사건 번호의 위치에서 시작
        val dis2 = if (p2 == 0) distance(n,n,case[next].first,case[next].second) else distance(case[p2].first,case[p2].second,case[next].first,case[next].second)
        val r1 = dis1 + totalDistance(next, p2) // 재귀 함수로 확인 -> next 사건을 p1이 해결 했을때
        val r2 = dis2 + totalDistance(p1, next) // 재귀 함수로 확인 -> next 사건을 p2가 해결 했을때
        dp[p1][p2] = min(r1,r2)
        return dp[p1][p2]
    }

    fun route(p1: Int, p2: Int){ // 사건별로 해결한 경찰차를 알려주는 함수, 위에 함수와 같은 방법으로 해결
        if(p1 == w || p2 == w) return
        val next = max(p1,p2) + 1
        val dis1 = if (p1 == 0) distance(1,1,case[next].first,case[next].second) else distance(case[p1].first,case[p1].second,case[next].first,case[next].second)
        val dis2 = if (p2 == 0) distance(n,n,case[next].first,case[next].second) else distance(case[p2].first,case[p2].second,case[next].first,case[next].second)
        if (dp[next][p2] + dis1 > dp[p1][next] + dis2) {
            println(2)
            route(p1, next)
        } else {
            println(1)
            route(next, p2)
        }
    }
    println(totalDistance(0,0))
    println(route(0,0))
}

