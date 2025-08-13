package com.kguard.tobecomebetter.baekjoon

import java.util.PriorityQueue
import kotlin.math.min

// 골드 4 특정한 최단 경로
// 그래프 이론, 데이크스트라(다익크스트라), 최단 경로
// 문제는 1번 부터 마지막 번째 간선 까지 가는데 최소거리를 구하는 도중 필수로 거쳐야하는 2개의 정점이 존재
// 1. 1번부터 v1까지의 최소거리 + v1부터 v2까지의 최소거리 + v2부터 마지막번째 까지의 최소거리
// 2. 1번부터 v2까지의 최소거리 + v2부터 v1까지의 최소거리 + v1부터 마지막번째 까지의 최소거리
// 1, 2 번중 더 작은 값이 최소거리가 되게 됨 -> 무조건 거쳐야한다는 조건이 있기 때문
fun main() {
    val (n, e) = readln().split(" ").map { it.toInt() }
    val graph = MutableList(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(e) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        graph[a].add(Pair(b, c))
        graph[b].add(Pair(a, c))
    }
    val (u, v) = readln().split(" ").map { it.toInt() }
    fun dijkstra(start: Int, end: Int): Int {
        val visited = MutableList(n + 1) { 200000001 } // 간선의 최대 갯수가 200000개 이고 가중치의 최대 값이 1000이기 때문에 최소거리값중 최대값은 200000000이 될 수 있기 때문에 초기값 200000001로 설정
        val queue = PriorityQueue<Pair<Int, Int>> { a, b -> a.second - b.second } // 두번째 값으로 비교하는 부분
        queue.add(Pair(start, 0))
        visited[start] = 0
        while (queue.isNotEmpty()) {
            val poll = queue.poll()
            if (poll.second > visited[poll.first]) continue // 새로 들어온 가중치가 이미 원래 있던 가중치보다 크면 for문을 돌 필요 없음 -> 이미 작은게 정해져있기 때문에 바꿀 이유가 없음
            for (i in graph[poll.first]) {
                if (visited[i.first] > visited[poll.first] + i.second) { // 새로 찾은 거리가 원래 거리보다 작은 경우
                    visited[i.first] = visited[poll.first] + i.second  // 최소거리를 새로 찾은 거리로 변경
                    queue.add(Pair(i.first, visited[i.first])) // 이동할 정점과 정점까지의 거리 큐에 추가
                }
            }
        }
        return visited[end]
    }
    val r1 = dijkstra(1, u) + dijkstra(u, v) + dijkstra(v, n) // 1. 1번부터 v1까지의 최소거리 + v1부터 v2까지의 최소거리 + v2부터 마지막번째 까지의 최소거리
    val r2 = dijkstra(1, v) + dijkstra(v, u) + dijkstra(u, n) // 2. 1번부터 v2까지의 최소거리 + v2부터 v1까지의 최소거리 + v1부터 마지막번째 까지의 최소거리
    val result = min(r1,r2)
    if(result >= 200000001) println(-1) else println(result)
}