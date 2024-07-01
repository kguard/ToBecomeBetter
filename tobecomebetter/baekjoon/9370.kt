package com.kguard.tobecomebetter.baekjoon

import java.util.PriorityQueue

// 골드 2 미확인 도착지
// 그래프 이론, 데이크스트라, 최단 경로
// 1504번을 참고해서 문제를 해결
// 문제를 확인하여 보면 결국 g-h 사이의 길을 자나가는 루트가 최간 경로가 된다는 의미
// 그래서 도착지 후보들 t에서
// 1. (s에서 t까지의 최소 거리) == (s에서 g까지의 최소 거리) + (g에서 h까지의 최소거리) + (h에서 t까지의 최소거리)
// 2. (s에서 t까지의 최소 거리) == (s에서 h까지의 최소 거리) + (h에서 g까지의 최소거리) + (g에서 t까지의 최소거리)
// 1, 2번중 하나를 만족하면 가능
fun main() {
    val T = readln().toInt()
    repeat(T) {
        val (n, m, t) = readln().split(" ").map { it.toInt() }
        val (s, g, h) = readln().split(" ").map { it.toInt() }
        val graph = MutableList(n + 1) { mutableListOf<Pair<Int, Int>>() }
        repeat(m) {
            val (a, b, c) = readln().split(" ").map { it.toInt() }
            graph[a].add(Pair(b, c))
            graph[b].add(Pair(a, c))
        }
        val list = mutableListOf<Int>()
        repeat(t) {
            list.add(readln().toInt())
        }
        fun dijkstra(start: Int, end: Int): Int {
            val visited =
                MutableList(n + 1) { 100000001 } // 간선의 최대 갯수가 200000개 이고 가중치의 최대 값이 1000이기 때문에 최소거리값중 최대값은 200000000이 될 수 있기 때문에 초기값 200000001로 설정
            val queue =
                PriorityQueue<Pair<Int, Int>> { a, b -> a.second - b.second } // 두번째 값으로 비교하는 부분
            queue.add(Pair(start, 0))
            visited[start] = 0
            while (queue.isNotEmpty()) {
                val poll = queue.poll()
                if (poll.second > visited[poll.first]) continue
                for (i in graph[poll.first]) {
                    if (visited[i.first] > visited[poll.first] + i.second) {
                        visited[i.first] = visited[poll.first] + i.second
                        queue.add(Pair(i.first, visited[i.first]))
                    }
                }
            }
            return visited[end]
        }
        list.sorted().forEach {
            if(dijkstra(s,it) == dijkstra(s, g) + dijkstra(g, h) + dijkstra(h, it) || dijkstra(s,it) == dijkstra(s, h) + dijkstra(h, g) + dijkstra(g, it))
                print("$it ")
        }
    }
}
