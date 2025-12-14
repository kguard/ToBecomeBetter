package com.kguard.tobecomebetter.baekjoon.kotlin

// 골드 4 인성 문제 있어?
// bfs 로 풀면됨
fun main() {
    val t = readln().toInt()
    val moveHeight = listOf(-1, 1, 0, 0)
    val moveWidth = listOf(0, 0, -1, 1)
    repeat(t) {
        val r = readln().split(" ").map { it.toInt() }
        val h = r[0]
        val w = r[1]
        val o = r[2]
        val f = r[3]
        val xs = r[4] -1
        val ys = r[5] -1
        val xe = r[6] -1
        val ye = r[7] -1
        val map = Array(h ) { Array(w ) { 0 } }
        val visit = Array(h ) { Array(w) { -1 } }
        repeat(o) {
            val (x, y, l) = readln().split(" ").map { it.toInt() }
            map[x-1][y-1] = l
        }
        val queue = ArrayDeque<Triple<Int, Int, Int>>()
        queue.add(Triple(xs, ys, f))
        visit[xs][ys] = f
        while (queue.isNotEmpty()) {
            val poll = queue.removeFirst()
            val x = poll.first
            val y = poll.second
            val nf = poll.third
            for (i in 0 until 4) {
                val nx = poll.first + moveHeight[i]
                val ny = poll.second + moveWidth[i]
                if (nx in 0 until h && ny in 0 until w && visit[nx][ny] < nf -1)  {
                    if((map[nx][ny] > map[x][y] && nf >= (map[nx][ny] - map[x][y])) || map[nx][ny] <= map[x][y]) {
                        visit[nx][ny] = nf - 1
                        queue.add(Triple(nx, ny, nf-1))
                    }
                }
            }
        }
//        map.forEach {
//            it.forEach { it1 -> print("$it1 ") }
//            println()
//        }
//        println()
//        visit.forEach {
//            it.forEach { it1 -> print("$it1 ") }
//            println()
//        }
        println(if (visit[xe][ye] >= 0) "잘했어!!" else "인성 문제있어??")

    }
}