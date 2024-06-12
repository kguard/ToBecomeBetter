package com.kguard.tobecomebetter.baekjoon

// 실버 3 바이러스
// 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색
// 1번 정점을 기준으로 너비 우선 탐색과, 깊이 우선 탐색을 해서 연결되어 있는 정점의 갯수를 구하는 문제
// count 만 추가 해줌
// dfs, bfs 둘다 해결 가능
fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val graph = MutableList(n + 1) { mutableListOf<Int>() } // 각 정점들이 연결되어 있는 정점들을 2차원 배열로 모아놓음
    val visited = MutableList(n + 1) { false }
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b) // 무방향 그래프이니 양쪽 정점에 둘다 추가 해줌
        graph[b].add(a)
    }
    var count = 0
    fun dfs(start: Int) {
        visited[start] = true // 찾은 정점 방문으로 변경
        for (i in graph[start]) // 연결되어 있는 정점들 중에서
            if (!visited[i]) {  // 방문하지 않았으면
                dfs(i) // 다시 dfs
                count++ // 이때 방문하였으니 count++
            }
    }

    val queue = mutableListOf<Int>() // 방문한 정점들이 들어갈 큐
    fun bfs(start: Int) {
        visited[start] = true // 정점 방문
        queue.add(start) // 큐에 정점 넣기
        while (queue.isNotEmpty()) { // 큐가 빌때 까지 반복
            val out = queue.removeFirst() // 맨 앞의 정점을 기준으로
            for (i in graph[out]) // 연결되어 있는 정점들 탐색
                if (!visited[i]) { // 방문하지 않았으면
                    visited[i] = true // 방문으로 변경
                    queue.add(i) // 큐 맨뒤에 정점 추가
                    count++ // 방문을 했으니 count++
                }
        }
    }
//    dfs(1)
//    bfs(1)
    println(count)
}