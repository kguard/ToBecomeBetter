package com.kguard.tobecomebetter.baekjoon

// 실버 2 DFS와 BFS
// 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색
fun main(){
    val (n, m, v) = readln().split(" ").map { it.toInt()}
    val graph = MutableList(n + 1) { mutableListOf<Int>() } // 각 정점들이 연결되어 있는 정점들을 2차원 배열로 모아놓음
    var visited = MutableList(n + 1) { false }
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b) // 무방향 그래프이니 양쪽 정점에 둘다 추가 해줌
        graph[b].add(a)
    }
    graph.forEach { it.sort() } // 간선 정렬
    fun dfs(start: Int) {
        visited[start] = true // 찾은 정점 방문으로 변경
        print("$start ")
        for (i in graph[start]) // 연결되어 있는 정점들 중에서
            if (!visited[i]) {  // 방문하지 않았으면
                dfs(i) // 다시 dfs
            }
    }

    val queue = mutableListOf<Int>() // 방문한 정점들이 들어갈 큐
    fun bfs(start: Int) {
        visited[start] = true // 정점 방문
        queue.add(start) // 큐에 정점 넣기
        print("$start ")
        while (queue.isNotEmpty()) { // 큐가 빌때 까지 반복
            val out = queue.removeFirst() // 맨 앞의 정점을 기준으로
            for (i in graph[out]) // 연결되어 있는 정점들 탐색
                if (!visited[i]) { // 방문하지 않았으면
                    visited[i] = true // 방문으로 변경
                    queue.add(i) // 큐 맨뒤에 정점 추가
                    print("$i ")
                }
        }
    }
    dfs(v)
    println()
    visited = MutableList(n + 1) { false }
    bfs(v)
}