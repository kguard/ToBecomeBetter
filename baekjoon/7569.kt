package com.kguard.tobecomebetter.baekjoon

import java.util.LinkedList
import java.util.Queue

// 골드 5 토마토(3차원)
// 그래프 이론, 그래프 탐색, 너비 우선 탐색
// bfs
// [z][y][x]
// 2차원 문제인 7576번을 참고해서 문제 해결
// 3차원으로 된 토마토 박스
fun main() {
    val (m, n, h) = readln().split(" ").map { it.toInt() }
    val list = mutableListOf<MutableList<MutableList<Int>>>()
    repeat(h) {
        val a = mutableListOf<MutableList<Int>>()
        repeat(n) {
            a.add(readln().split(" ").map { it.toInt() }.toMutableList())
        }
        list.add(a)
    }
    val moveHeight = mutableListOf(1, -1, 0, 0, 0, 0) // 아래, 위로 이동 하는 부분
    val moveWidth = mutableListOf(0, 0, 1, -1, 0, 0) // 오른쪽, 왼쪽으로 이동하는 부분
    val upDown = mutableListOf(0, 0, 0, 0, 1, -1) // 층을 이동하는 부분
    val queue: Queue<Triple<Int, Int, Int>> = LinkedList() // 시간초과로 인해 사용
    for (i in 0 until h)
        for (j in 0 until n)
            for (t in 0 until m)
                if (list[i][j][t] == 1)
                    queue.add(Triple(i, j, t))  // 처음에 list에서 1인 부분의 좌표를 queue에 추가
    fun bfs() {
        while (queue.isNotEmpty()) {
            val poll = queue.poll()
            for (i in 0 until 6) {
                val nz = upDown[i] + poll.first
                val ny = moveHeight[i] + poll.second
                val nx = moveWidth[i] + poll.third
                if (ny in 0 until n && nx in 0 until m && nz in 0 until h && list[nz][ny][nx] == 0) {
                    list[nz][ny][nx] = list[poll.first][poll.second][poll.third] + 1
                    queue.add(Triple(nz, ny, nx))
                }
            }
        }
    }
    bfs()
    var result = list.maxOf { it.maxOf { it.max() } } - 1
    for (i in list)
        for (j in i)
            if (0 in j) {
                result = -1
                break
            }
    println(result)
}