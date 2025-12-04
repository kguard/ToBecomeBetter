package com.kguard.tobecomebetter.baekjoon.kotlin

import kotlin.math.min
// 골드 3 말이 되고픈 원숭이
// 3차원 배열을 이용한 bfs
fun main() {
    val k = readln().toInt()
    val (w, h) = readln().split(" ").map { it.toInt() }
    val map = mutableListOf<List<Int>>()
    repeat(h) {
        map.add(readln().split(" ").map { it.toInt() })
    }
    val moveHeight = listOf(-1, 1, 0, 0)
    val moveWidth = listOf(0, 0, -1, 1)
    val moveHorseH = listOf(-1, -2, -2, -1, 1, 2, 2, 1)
    val moveHorseW = listOf(-2, -1, 1, 2, -2, -1, 1, 2)
    val dp = Array(h) { Array(w) { IntArray(k+1) {Int.MAX_VALUE } } } // [0]은 말 같이 움직인 횟수, [1]은 최소 이동 횟수
    fun check() {
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.add(0 to 0)
        dp[0][0][0] = 1
        while (queue.isNotEmpty()) {
            val poll = queue.removeFirst()
            val y = poll.first
            val x = poll.second
            if (dp[y][x][0] <= k - 1) {
                for (i in 0 until 8) {
                    val ny = y + moveHorseH[i]
                    val nx = x + moveHorseW[i]
                    if (ny in 0 until h && nx in 0 until w && map[ny][nx] == 0 && dp[ny][nx][1] > dp[y][x][1] + 1) {
                        dp[ny][nx][0] = dp[y][x][0] + 1
                        dp[ny][nx][1] = min(dp[ny][nx][1], dp[y][x][1] + 1)
                        queue.add(ny to nx)
                    }
                }
            }

            for (i in 0 until 4) {
                val ny = y + moveHeight[i]
                val nx = x + moveWidth[i]
                if (ny in 0 until h && nx in 0 until w && map[ny][nx] == 0 && dp[ny][nx][1] > dp[y][x][1] + 1) {
                    dp[ny][nx][0] = dp[y][x][0]
                    dp[ny][nx][1] = min(dp[ny][nx][1], dp[y][x][1] + 1)
                    queue.add(ny to nx)
                }
            }

        }
    }
    check()
    dp.forEach { println(it.joinToString(" ") { i -> i.contentToString() }) }
    println(if (dp[h - 1][w - 1][1] == Int.MAX_VALUE) -1 else dp[h - 1][w - 1][1])

}