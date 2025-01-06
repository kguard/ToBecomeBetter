package com.kguard.tobecomebetter.baekjoon

// 실버 2 연결 요소의 개수
// 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색
// bfs와 dfs의 기본문제 
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = MutableList(n + 1) { mutableListOf<Int>() }
    val group = MutableList(n + 1) { 0 }
    repeat(m) {
        val (u, v) = readln().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }
    fun dfs(now: Int, g: Int) {
        if (group[now] == 0)
            group[now] = g
        for (i in graph[now]) {
            if (group[i] == 0)
                dfs(i, g)
        }
    }

    fun bfs(now: Int, g: Int) {
        val queue = mutableListOf<Int>()
        queue.add(now)
        group[now] = g
        while (queue.isNotEmpty()) {
            val poll = queue.removeAt(0)
            for (i in graph[poll])
                if (group[i] == 0) {
                    queue.add(i)
                    group[i] = g
                }
        }
    }

    var g = 1
    for (i in 1..n) {
        if (group[i] == 0) {
//            dfs(i, g)
            bfs(i, g)
            g++
        }
    }
//    println(group)
    println(group.max())
}
