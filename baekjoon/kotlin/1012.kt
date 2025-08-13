package com.kguard.tobecomebetter.baekjoon

// 실버 2 유기농 배추
// 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색
// bfs를 이용하여 문제 해결
// 상하좌우로 이동하며, 갯수를 세며, 하나씩 추가하여 총 갯수를 셈
fun main() {
    val moveHeight = mutableListOf(1, -1, 0, 0) // 아래, 위로 이동 하는 부분
    val moveWidth = mutableListOf(0, 0, 1, -1) // 오른쪽, 왼쪽으로 이동하는 부분
    val t = readln().toInt()
    repeat(t) {
        val (n, m, k) = readln().split(" ").map { it.toInt() }
        val list = MutableList(n) { MutableList(m) { 0 } }
        repeat(k) {
            val (x, y) = readln().split(" ").map { it.toInt() }
            list[x][y] = 1
        }
        val visited = MutableList(n) { MutableList(m) { false } }
        val queue = mutableListOf<Pair<Int, Int>>()
        val count = mutableListOf<Int>()
        fun bfs(x: Int, y: Int): Int {
            visited[x][y] = true
            queue.add(Pair(x, y))
            var c = 1
            while (queue.isNotEmpty()) {
                val poll = queue.removeFirst()
                for (i in 0 until 4) { // 상하좌우로 움직이기 위해 반복
                    val nx = moveHeight[i] + poll.first // 아래, 위
                    val ny = moveWidth[i] + poll.second // 오른쪽, 왼쪽
                    if (nx in list.indices && ny in list[0].indices && list[nx][ny] == 1 && !visited[nx][ny]) //  상하좌우로 움직인 좌표가 인덱스 안에 있고, 움직인 좌표가 찾는 숫자 이고, 방문하지 않았으면
                    {
                        visited[nx][ny] = true
                        queue.add(Pair(nx, ny))
                        c++
                    }
                }
            }
            return c
        }
        for (i in list.indices)
            for (j in list[0].indices)
                if (list[i][j] == 1 && !visited[i][j]) {
                    count.add(bfs(i, j))
                }
        println(count.size)
    }
}

