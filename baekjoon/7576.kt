package com.kguard.tobecomebetter.baekjoon

import java.util.LinkedList
import java.util.Queue

// 골드 5 토마토
// 그래프 이론, 그래프 탐색, 너비 우선 탐색
// 최소 시간을 구하는 방식이기 때문에 bfs로 진행
// 1인 부분에서 동시에 시작하기 때문에
// 초기에 1에 해당하는 부분을 모두 queue에 추가
fun main() {
    val (m, n) = readln().split(" ").map { it.toInt() }
    val list = mutableListOf<MutableList<Int>>()
    repeat(n) {
        list.add(readln().split(" ").map { it.toInt() }.toMutableList())
    }
//    val queue = mutableListOf<Pair<Int, Int>>()
    val queue: Queue<Pair<Int, Int>> = LinkedList() // 시간초과로 인해 사용
    val moveHeight = mutableListOf(1, -1, 0, 0) // 아래, 위로 이동 하는 부분
    val moveWidth = mutableListOf(0, 0, 1, -1) // 오른쪽, 왼쪽으로 이동하는 부분
    for (i in 0 until n)
        for (j in 0 until m)
            if (list[i][j] == 1)
                queue.add(Pair(i, j))  // 처음에 list에서 1인 부분의 좌표를 queue에 추가
    fun bfs() {
        while (queue.isNotEmpty()) {
            val poll = queue.poll()
            for (i in 0 until 4) {
                val nx = moveHeight[i] + poll.first
                val ny = moveWidth[i] + poll.second
                if (nx in 0 until n && ny in 0 until m && list[nx][ny] == 0) {
                    list[nx][ny] = list[poll.first][poll.second] + 1
                    queue.add(Pair(nx, ny))
                }
            }
        }
    }
    bfs()
    var result = list.maxOf { it.max() } - 1
    for (i in list)
        if (0 in i) {
            result = -1
            break
        }
    println(result)
}