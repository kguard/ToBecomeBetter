package com.kguard.tobecomebetter.baekjoon.kotlin

import kotlin.math.abs

/*
    골드 4 인구 이동
    bfs로 문제를 풀면 됨, 각 인구가 이동했는지를 체크해서 풀면 됨
*/
fun main() {
    val (n, l, r) = readln().split(" ").map { it.toInt() }
    val a = mutableListOf<MutableList<Int>>()
    repeat(n) {
        a.add(readln().split(" ").map { it.toInt() }.toMutableList())
    }
    val moveHeight = arrayOf(0, 0, -1, 1)
    val moveWidth = arrayOf(-1, 1, 0, 0)
    var day = 0
    while (true) {
        val land = Array(n) { IntArray(n) { 0 } }
        fun bfs(group: Int, sy: Int, sx: Int): Boolean {
            var sum = a[sy][sx] // 전체 인구수 (국경을 열었을때)
            var count = 1 // 연 국가의 개수
            val q = ArrayDeque<Pair<Int, Int>>()
            val save = ArrayDeque<Pair<Int, Int>>() // 국가의 좌표들
            land[sy][sx] = group
            q.add(sy to sx)
            save.add(sy to sx)
            while (q.isNotEmpty()) {
                val poll = q.removeFirst()
                for (i in 0 until 4) {
                    val ny = poll.first + moveHeight[i]
                    val nx = poll.second + moveWidth[i]
                    if (ny in 0 until n && nx in 0 until n && land[ny][nx] == 0 && abs(a[poll.first][poll.second] - a[ny][nx]) in l..r) {
                        land[ny][nx] = group
                        q.add(ny to nx)
                        save.add(ny to nx)
                        sum += a[ny][nx]
                        count++
                    }
                }
            }
            if (count > 1) { // 국가의 개수가 1개 보다 많으면 -> 이동 했다는 증거
                for (i in save) { // 인구 이동
                    a[i.first][i.second] = sum / count
                }
                return true // 인구 이동 발생
            }
            return false // 인구 이동이 발생하지 않음
        }

        var isMoved = false
        var c = 1 // 각 국경의 개수를 뜻함
        for (i in 0 until n)
            for (j in 0 until n) {
                if (land[i][j] == 0) {
                    if (bfs(c, i, j))
                        isMoved = true
                    c++
                }
            }
        if (!isMoved)
            break
        day++
    }
    println(day)
}