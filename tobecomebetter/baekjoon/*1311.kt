package com.kguard.tobecomebetter.baekjoon

import kotlin.math.min

// 골드 1 할 일 정하기1
// 다이나믹 프로그래밍, 비트마스킹, 비트필드를 이용한 다이나믹 프로그래밍
// 이해 불가.. 비트마스킹 이해를 하지 못했음
// 그리디(현재 기준으로 제일 좋은 것만 고르는 것) 으로 문제를 해결할 수 없음
// DP[x][visited] = 현재 x번째 사람을 보고 있고 그 전까지 방문한 조합이 visited 일 때의 최솟값.
// x는 현재 보고 있는 사람이고, visited은 그 전까지 방문한 조합을 의미함.
// dp[현재 사람][이전까지 수행한 일의 상태] = 현재 일의 상태까지의 최솟값
// 이전까지 수행한 일의 상태를 0011 -> 1, 2번이 일을 한 상태와 같이 비트를 이용하여 상태를 표시한다.
fun main() {
    val n = readln().toInt()
    val list = mutableListOf<MutableList<Int>>()
    val dp = MutableList(n) { MutableList(1 shl n) { 0 } }
    repeat(n) {
        list.add(readln().split(" ").map { it.toInt() }.toMutableList())
    }
    fun dfs(now: Int, visited: Int): Int {
        if (now == n) return 0
        if (dp[now][visited] != 0) return dp[now][visited]
        var result = Int.MAX_VALUE
        for (i in 0 until n) {
            if ((visited and (1 shl i)) == 0) { // i번째의 상태를 확인하기 위함
                result = min(result, list[now][i] + dfs(now + 1, visited or (1 shl i)))  // or를 사용해서 visited가 이미 사용 된걸로 함
            }
        }
        dp[now][visited] = result
        return dp[now][visited]
    }
    println(dfs(0, 0))
}