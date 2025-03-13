package com.kguard.tobecomebetter.baekjoon

// 실버 1 쉬운 최단거리
// 그래프 이론, 그래프 탐색, 너비 우선 탐색
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = mutableListOf<List<Int>>()
    val distance = MutableList(n) { MutableList(m) { -1 } }
    repeat(n) { graph.add(readln().split(" ").map { it.toInt() }) }
    var start = Pair(0, 0)
    for (i in graph.indices)
        for (j in graph[i].indices) {
            if (graph[i][j] == 2) {
                start = Pair(i, j)
            } else if (graph[i][j] == 0)
                distance[i][j] = 0
        }
    distance[start.first][start.second] = 0
    val moveHeight = mutableListOf(1, -1, 0, 0)
    val moveWidth = mutableListOf(0, 0, 1, -1)
    fun bfs(y: Int, x: Int) {
        val queue = mutableListOf<Pair<Int, Int>>()
        queue.add(Pair(y, x))
        while (queue.isNotEmpty()) {
            val poll = queue.removeAt(0)
            for (i in 0 until 4) {
                val ny = moveHeight[i] + poll.first
                val nx = moveWidth[i] + poll.second
                if (ny in 0 until n && nx in 0 until m && graph[ny][nx] == 1 && distance[ny][nx] == -1) {
                    distance[ny][nx] = distance[poll.first][poll.second] + 1
                    queue.add(Pair(ny, nx))
                }
            }
        }
    }
    bfs(start.first, start.second)
    for (i in distance.indices) {
        for (j in distance[i].indices) {
            print("${distance[i][j]} ")
        }
        println()
    }
}