package com.kguard.tobecomebetter.baekjoon

// 골드 5 뱀과 사다리 게임
// 그래프 이론, 그래프 탐색, 너비 우선 탐색
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
        queue.add(1)
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