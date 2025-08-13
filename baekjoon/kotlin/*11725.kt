package com.kguard.tobecomebetter.baekjoon

// 실버 2 트리의 부모 찾기
// 그래프 이론, 그래프 탐색, 트리, 너비 우선 탐색, 깊이 우선 탐색
// 부모 노드가 1인 트리에서 그래프를 가지고 부모 노드를 구하는 방식 bfs, dfs 둘 다 해결 가능
fun main() {
    val n = readln().toInt()
    val graph = MutableList(n + 1) { mutableListOf<Int>() }
    val visited = MutableList(n + 1) { 0 }
    repeat(n - 1) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }
    fun dfs(s: Int) {
        for (i in graph[s])
            if (visited[i] == 0) {
                visited[i] = s
                dfs(i)
            }
    }
//    dfs(1)
    fun bfs(s: Int) {
        val queue = mutableListOf<Int>()
        queue.add(s)
        while (queue.isNotEmpty()) {
            val poll = queue.removeFirst()
            for (i in graph[poll])
                if (visited[i] == 0) {
                    visited[i] = poll
                    queue.add(i)
                }
        }
    }
    bfs(1)
    for(i in 2..n)
        println(visited[i])
}