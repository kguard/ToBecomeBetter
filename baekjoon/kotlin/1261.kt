package com.kguard.tobecomebetter.baekjoon.kotlin

// 골드 4 알고스팟
// 01 bfs를 이용해서 푸는 문제 ( 가중치가 2개여야 하고 하나는 무조건 0 이어야함, 나머지는 양수중 하나만)
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = mutableListOf<MutableList<Int>>()
    repeat(m) {
        map.add(readln().map { it - '0' }.toMutableList())
    }
    fun bfs(): Int {
        val moveWidth = arrayOf(0, 0, -1, 1)
        val moveHeight = arrayOf(-1, 1, 0, 0)
        val visited = Array(m) { Array(n) { Int.MAX_VALUE} }
        val queue = ArrayDeque<Triple<Int, Int, Int>>()
        queue.add(Triple(0, 0, 0))
        visited[0][0] = 0
        while (queue.isNotEmpty()) {
            val poll = queue.removeFirst()
            for (i in 0 until 4) {
                val ny = poll.first + moveHeight[i]
                val nx = poll.second + moveWidth[i]
                if (ny in 0 until m && nx in 0 until n) {
                    val newCost = poll.third + map[ny][nx] // 다음이 벽인지 아닌지 판단해서 새롭게 생기는 비용
                    if (visited[ny][nx] > newCost) { // 비용이 갱신 되면 (새로운 비용이 기존 비용보다 작으면)
                        visited[ny][nx] = newCost // 비용 갱신
                        if (map[ny][nx] == 0) // 하지만 벽이 아닌 경우는 앞에 넣어서 더 그 길을 먼저 움직이기, 아니면 뒤에 넣기
                            queue.addFirst(Triple(ny, nx, newCost))
                        else
                            queue.addLast(Triple(ny, nx, newCost))
                    }
                }
            }
        }
        return visited[m - 1][n - 1]
    }
    println(bfs())
}