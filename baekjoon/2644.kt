package com.kguard.tobecomebetter.baekjoon

// 실버 2 촌수계산
// 그래프 이론, 그래프 탐색, 너비 우선 탐색(bfs), 깊이 우선 탐색(dfs)
fun main() {
    val n = readln().toInt()
    val (s, e) = readln().split(" ").map { it.toInt() }
    val m = readln().toInt()
    val graph = MutableList(n + 1) { mutableListOf<Int>() }
    val visit = MutableList(n + 1) { -1 }
    repeat(m) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        graph[x].add(y)
        graph[y].add(x)
    }
    fun bfs(s: Int, e: Int): Int {
        val queue = mutableListOf<Int>()
        visit[s] = 0
        queue.add(s)
        while (queue.isNotEmpty()) {
            val poll = queue.removeAt(0)
            for (i in graph[poll])
                if (visit[i] == -1) {
                    visit[i] = visit[poll] + 1
                    queue.add(i)
                }
        }
        return visit[e]
    }
    print(bfs(s, e))
    
    fun dfs(now: Int, count: Int) {
        visit[now] = count
        for (i in graph[now])
            if (visit[i] == -1)
                dfs(i, count + 1)
    }
//    dfs(s,0)
//    print(visit[e])
}