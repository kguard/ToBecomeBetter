package com.kguard.tobecomebetter.baekjoon

import kotlin.math.max

// 골드 1 트리의 독립집합
// 다이나믹 프로그래밍, 트리, 트리에서의 다이나믹 프로그래밍
// 서로 인접하지 않은 정점 들의 가중치의 최대 값을 구하는 문제
fun main() {
    val n = readln().toInt()
    val w = readln().split(" ").map { it.toInt() }
    val graph = MutableList(n + 1) { mutableListOf<Int>() }
    val dp = MutableList(n + 1) { mutableListOf(0, 0) } // 0 번째는 독립 집합에 안들어갈 경우, 1 번째는 독립 집합에 들어갈 경우
    val visited = MutableList(n + 1) { false }
    val path = mutableListOf<Int>()
    repeat(n - 1) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }
    // 서로 인접하지 않은 정점들의 가중치의 최대 값을 구해야됨
    fun dfs(s: Int) { // 독립 집합들의 최대 값을 구하는 과정
        dp[s][1] = w[s - 1]
        visited[s] = true
        for (i in graph[s]) {
            if (!visited[i]) {
                dfs(i)
                dp[s][0] += max(
                    dp[i][1],
                    dp[i][0]
                ) // 현재 값이 독립 집합에 안들어 갈 경우, 연결 되어 있는 정점이 들어가던, 안들어가던 상관 없음
                dp[s][1] += dp[i][0] // 현재 값이 독립 집합에 들어가려하면, 연결되어 있는 정점은 무조건 들어가면 안됨 -> dp[연결되어 있는 점정][독립집하에 들어가지 않을 경우] 를 더해야됨
            }
        }
    }
    dfs(1)
    println(dp[1].max())
    val check = MutableList(n + 1) { false }

    // 루트를 구하는 과정
    // 연결 되어 있지 않은 정점을 구해야 되기 때문에 이전 정점을 확인
    fun tracing(now: Int, prev: Int) {
        if (dp[now][1] > dp[now][0] && !check[prev]) { // 현재의 정점이 들어갔을 때가 더 크고, 이전 정점이 들어가지 않았을때 -> 독립 집합에 들어가는 경우의 수
            path.add(now)
            check[now] = true
        }
        for (i in graph[now]) { // 연결되어 있는 간선을 기준으로
            if (i == prev) continue // 무한 루프가 발생하지 않도록 하기 위해서
            tracing(i, now)
        }
    }
    println(dp)
    tracing(1, 0)
    for (i in path.sorted())
        print("$i ")
}