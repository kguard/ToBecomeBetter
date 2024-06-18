package com.kguard.tobecomebetter.baekjoon

// 실버 1 숨바꼭질
// 그래프 이론, 그래프 탐색, 너비 우선 탐색
// 최소 시간을 구하는 문제이기 때문에 bfs를 사용
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val queue = mutableListOf<Int>()
    val visited = MutableList(100001) { 0 }
    fun bfs(a: Int) {
        queue.add(a)
        while (queue.isNotEmpty()) {
            val now = queue.removeFirst()
            if (now == k) { // 원하는 숫자에 도달 하였을 때
                println(visited[now])
                return
            }
            val value = mutableListOf(now-1, now+1, now*2) // 순간이동을 하거나 앞뒤로 이동 하였을 때
            for(i in value)
                if(i in 0..100000 && visited[i] == 0) { // 범위 내에 있고, 방문하지 않았을 때
                    visited[i] = visited[now] + 1 // 최소거리 구하기
                    queue.add(i)
                }
        }
    }
    bfs(n)
}