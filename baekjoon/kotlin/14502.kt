package com.kguard.tobecomebetter.baekjoon.kotlin

import kotlin.math.max

// 골드 4 연구소
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = MutableList(n) { MutableList(m) { 0 } }
    val empty = mutableListOf<Pair<Int, Int>>()
    val virus = mutableListOf<Pair<Int, Int>>()
    val newWall = mutableListOf<Pair<Int, Int>>()
    var max = 0
    for (i in 0 until n) {
        val e = readln().split(" ").map { it.toInt() }
        for (j in 0 until m) {
            if (e[j] > 1) {
                map[i][j] = e[j]
                virus.add(i to j)
            }
            else if (e[j] == 1)
                map[i][j] = 1
            else
                empty.add(i to j)
        }
    }


    fun checkBfs(): Int {
        val newMap = map.map { it.toMutableList() }.toMutableList()
        newWall.forEach { it -> newMap[it.first][it.second] = 1 }
        val moveHeight = listOf(-1, 1, 0, 0)
        val moveWidth = listOf(0, 0, 1, -1)

        val q = ArrayDeque<Pair<Int, Int>>()
        virus.forEach { q.add(it) }
        while (q.isNotEmpty()) {
            val poll = q.removeFirst()
            for (i in 0 until 4) {
                val ny = poll.first + moveHeight[i]
                val nx = poll.second + moveWidth[i]
                if (ny in 0 until n && nx in 0 until m && newMap[ny][nx] == 0) {
                    newMap[ny][nx] = 2
                    q.add(ny to nx)
                }
            }
        }

        var count = 0
        newMap.forEach { it.forEach { it2 -> if (it2 == 0) count++ } }
        return count

    }

    fun comb(cnt: Int, start: Int) {
        if (cnt == 3) {
            max = max(max, checkBfs())
            return
        }
        for (i in start until empty.size) {
            newWall.add(empty[i])
            comb(cnt + 1, i + 1)
            newWall.removeAt(newWall.lastIndex)
        }
    }
    comb(0, 0)
    println(max)

}