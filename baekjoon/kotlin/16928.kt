package com.kguard.tobecomebetter.baekjoon

// 골드 5 뱀과 사다리 게임
// 그래프 이론, 그래프 탐색, 너비 우선 탐색
// bfs를 사용하여 주사위가 6까지 이기 모두 움직이는 최소 거리를 구하는 식
// 움직였을때 사다리나 뱀을 만나면 이동
// 1부터 100까지 가는 최소거리
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val ladderSnake = mutableMapOf<Int, Int>()
    val list = MutableList(101) { 0 }
    val visited = MutableList(101) { false }
    val queue = mutableListOf<Int>()
    repeat(n + m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        ladderSnake[a] = b
    }
    fun bfs() {
        queue.add(1) // 1부터 시작
        visited[1] = true
        while (queue.isNotEmpty()) {
            val poll = queue.removeFirst()
            for (i in 1..6) {
                var next = poll + i
                if (next in ladderSnake.keys)
                    next = ladderSnake[next]!!
                if (next in 1..100 && !visited[next]) {
                    list[next] = list[poll] + 1
                    visited[next] = true
                    queue.add(next)
                }
            }
        }
    }
    bfs()
    println(list[100])
    println(list)
}