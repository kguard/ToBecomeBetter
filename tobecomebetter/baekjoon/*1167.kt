package com.kguard.tobecomebetter.baekjoon

// 골드 2 트리의 지름
// 그래프 이론, 그래프 탐색, 트리, 깊이 우선 탐색(dfs)
// bfs, dfs 둘다 가능
// 트리의 지름 -> 노드 사이의 거리가 제일 긴 노드 간의 거리
// 트리의 특성을 생각해 보면 모든 정점은 사이클이 없이 연결이 되어 있고, 한 정점에서 다른 정점으로 가는 경로는 유일하다. 그래서 가장 멀리있는 두 정점의 경로는 항상 유일하다.
// 가장 긴 정점의 경로는 결국 어느 정점에서의 가장 먼 거리에 있는 정점의 경로와 겹칠 수밖에 없는 것이다.
// 어느 점에서 시작 하던 제일 마지막에 있는 점까지가 제일 멀다
// 1. 임의의 점을 선택해 거리 구해서 가장 멀리 있는 점을 구하기
// 2. 가장 긴 거리에 있는 점을 대상으로 다시 거리 구해서 최대 값
fun main() {
    val n = readln().toInt()
    val graph = MutableList(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(n) {
        val m = readln().split(" ").map { it.toInt() }.toMutableList()
        val s = m.removeFirst()
        m.removeLast()
        for (i in 0 until m.size step 2)
            graph[s].add(Pair(m[i], m[i + 1]))
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
    val max = visited.indexOf(visited.max())
    visited = MutableList(n + 1) { -1 }
    visited[max] = 0
//    dfs(max, 0)
    bfs(max)
    println(visited.max())
}