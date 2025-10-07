package com.kguard.tobecomebetter.baekjoon.kotlin

import java.util.PriorityQueue
import kotlin.math.max

// 골드 3 파티
// 모든 정점에 대해서 다익스트라를 돌려서 (모든 정점 -> 파티하는 정점의 최단거리) + (파티하는 정점 -> 모든 정점의 최단거리) 의 최댓값을 구함
fun main() {
    val (n, m, x) = readln().split(" ").map { it.toInt() }
    val graph = List(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(m) {
        val (s, e, t) = readln().split(" ").map { it.toInt() }
        graph[s].add(e to t)
    }

    fun dijkstra(start: Int): MutableList<Int> {
        val dist = MutableList(n + 1) { Int.MAX_VALUE }
        val queue = PriorityQueue<Pair<Int, Int>>() { p1, p2 -> p1.second.compareTo(p2.second) }
        queue.add(start to 0) // 도착정점, 도착정점까지의 거리
        dist[start] = 0
        while (queue.isNotEmpty()) {
            val poll = queue.poll()
            val minVertex = poll.first
            val min = poll.second

            if (min > dist[minVertex])
                continue

            for (i in graph[minVertex]) {
                if (dist[i.first] > min + i.second) {
                    dist[i.first] = min + i.second
                    queue.add(i.first to dist[i.first])
                }
            }
        }
        return dist
    }

    var max = 0
    val xd = dijkstra(x)
    for (i in 1..n) {
        if (i == x)
            continue
        max = max(xd[i] + dijkstra(i)[x], max)
    }
    println(max)
}