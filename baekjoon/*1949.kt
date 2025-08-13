package com.kguard.tobecomebetter.baekjoon

import kotlin.math.max

// 골드 2 우수 마을
// 다이나믹 프로그래밍, 트리, 트리에서의 다이나믹 프로그래밍
// 2213번과 같은 방식으로 푸는 문제
// 1. '우수 마을'로 선정된 마을 주민 수의 총 합을 최대로 해야 한다.
// 2. 마을 사이의 충돌을 방지하기 위해서, 만일 두 마을이 인접해 있으면 두 마을을 모두 '우수 마을'로 선정할 수는 없다. 즉 '우수 마을'끼리는 서로 인접해 있을 수 없다.
// 3. 선정되지 못한 마을에 경각심을 불러일으키기 위해서, '우수 마을'로 선정되지 못한 마을은 적어도 하나의 '우수 마을'과는 인접해 있어야 한다.
fun main() {
    val n = readln().toInt()
    val w = readln().split(" ").map { it.toInt() }
    val graph = MutableList(n + 1) { mutableListOf<Int>() }
    val dp = MutableList(n + 1) { mutableListOf(0, 0) }
    val visited = MutableList(n + 1) { false }
    repeat(n - 1) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }
    fun dfs(s: Int) {
        dp[s][1] = w[s - 1] //  우수 마을일때는 주민수를 더해줘야함
        visited[s] = true
        for (i in graph[s]) {
            if (!visited[i]) {
                dfs(i)
                dp[s][1] += dp[i][0]  // 조건 2를 만족하기 위해서 우수 마을 옆에는 무조건 일반 마을이 들어가야 함
                dp[s][0] += max(dp[i][0], dp[i][1]) // 조건 1과 조건 3을 만족하기 위해서 다음번 마을이 우수마을이던 아니던 상관 없이 제일 큰 값을 넣어주면 됨
            }
        }
    }
    dfs(1)
    println(dp[1].max())
}