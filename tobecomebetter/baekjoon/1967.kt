package com.kguard.tobecomebetter.baekjoon

// 골드 4 트리의 지름
// 그래프 이론, 그래프 탐색, 트리, 깊이 우선 탐색(dfs)
// bfs, dfs 둘 다 해결 가능
// 1167번과 정확히 같은 방식으로 풀기
// 트리의 특성을 생각해 보면 모든 정점은 사이클이 없이 연결이 되어 있고, 한 정점에서 다른 정점으로 가는 경로는 유일하다. 그래서 가장 멀리있는 두 정점의 경로는 항상 유일하다.
// 가장 긴 정점의 경로는 결국 어느 정점에서의 가장 먼 거리에 있는 정점의 경로와 겹칠 수밖에 없는 것이다.
// 1. 임의의 점을 선택해 거리 구해서 가장 멀리 있는 점을 구하기
// 2. 1번에서 구한 가장 멀리 있는 점을 기준으로 다시 거리 구해서 최대 값
fun main() {
    val n = readln().toInt()
    val graph = MutableList(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(n-1) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        graph[a].add(Pair(b, c)) // 먼저 간선에서 가는 방향 추가
        graph[b].add(Pair(a, c)) // 반대 쪽에도 가는 방향 추가
    }
    var visited = MutableList(n + 1) { -1 }
    visited[1] = 0
    fun dfs(s: Int, v: Int) {
        for (t in graph[s]) {
            val dis = v + t.second // 거리를 기억 해 놨다가 이동하는 식으로 문제 풀기
            if (visited[t.first] == -1) {
                visited[t.first] = dis
                dfs(t.first, dis)
            }
        }
    }
    fun bfs(s: Int) {
        val queue = mutableListOf<Pair<Int, Int>>()
        queue.add(Pair(s, 0))
        while (queue.isNotEmpty()) {
            val poll = queue.removeFirst()
            for (i in graph[poll.first])
                if (visited[i.first] == -1) {
                    val dis = i.second + poll.second
                    visited[i.first] = dis
                    queue.add(Pair(i.first, dis))
                }
        }
    }
//    dfs(1, 0)
    bfs(1)
    println(visited)
    val max = visited.indexOf(visited.max())
    visited = MutableList(n + 1) { -1 }
    visited[max] = 0
    bfs(max)
//    dfs(max, 0)
    println(visited)
    println(visited.max())

}