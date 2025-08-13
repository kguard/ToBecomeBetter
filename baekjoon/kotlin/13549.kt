package com.kguard.tobecomebetter.baekjoon

// 골드 5 숨바꼭질3
// 그래프 이론, 그래프 탐색, 너비 우선 탐색, 데이크스트라, 최단 경로, 0-1 너비 우선 탐색
// 가중치가 더 낮은 걸 기준으로 탐색 -> *2가 먼저 큐에 넣는 방식으로 해결
// +1 -1 로 먼저 이동하면 안됨 -> 1초가 걸리기 때문에
// 같은 시간이 걸리는 *2 부터 수행
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val visited = MutableList(100001) { Int.MAX_VALUE }
    val queue = mutableListOf<Int>()
    fun dijkstra() {
        queue.add(n)
        visited[n] = 0
        while (queue.isNotEmpty()) {
            val poll = queue.removeFirst()
            if (poll == k) { // 원하는 숫자에 도달 하였을 때
                println(visited[poll])
                return
            }
            val move = mutableListOf(poll - 1, poll + 1) // 순간이동을 하거나 앞뒤로 이동 하였을 때
            val teleport = poll * 2
            if (teleport in 0..100000 && visited[teleport] == Int.MAX_VALUE) { // 가중치가 더 낮기 때문에 먼저 계산
                visited[teleport] = visited[poll]
                queue.add(teleport)
            }
            for (i in move) {
                if (i in 0..100000 && visited[i] == Int.MAX_VALUE) {
                    visited[i] = visited[poll] + 1
                    queue.add(i)
                }
            }
        }
    }
    dijkstra()
}