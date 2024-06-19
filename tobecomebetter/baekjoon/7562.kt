package com.kguard.tobecomebetter.baekjoon

// 살버 1 나이트의 이동
// 그래프 이론, 그래프 탐색, 너비 우선 탐색
// bfs 사용
// 나이트가 이동하는 방향이 8방향
// list의 값을 이동한 횟수로 지정
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val i = readln().toInt()
        val list = MutableList(i) { MutableList(i) { 0 } }
        val visited = MutableList(i) { MutableList(i) { false } }
        val queue = mutableListOf<Pair<Int, Int>>()
        val (sx, sy) = readln().split(" ").map { it.toInt() }
        val (ex, ey) = readln().split(" ").map { it.toInt() }
        val moveHeight = mutableListOf(1, -1, 1, -1, 2, -2, 2, -2) // 아래, 위로 이동 하는 부분
        val moveWidth = mutableListOf(2, 2, -2, -2, 1, 1, -1, -1) // 오른쪽, 왼쪽으로 이동하는 부분
        fun bfs() {
            queue.add(Pair(sx, sy))
            visited[sx][sy] = true
            while (queue.isNotEmpty()) {
                val poll = queue.removeFirst()
                for (j in 0..7) {
                    val nx = poll.first + moveWidth[j]
                    val ny = poll.second + moveHeight[j]
                    if (nx in list.indices && ny in list.indices && !visited[nx][ny]) {
                        list[nx][ny] = list[poll.first][poll.second] + 1
                        visited[nx][ny] = true
                        queue.add(Pair(nx, ny))
                    }
                }
            }
        }
        bfs()
        println(list[ex][ey])
    }
}