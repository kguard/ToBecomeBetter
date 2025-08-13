package com.kguard.tobecomebetter.baekjoon

// 실버 4 빙고
// 구현, 시뮬레이션
// 대각선도 찾아줘야 됨
fun main() {
    val graph = mutableListOf<List<Int>>()
    val bool = MutableList(5) { MutableList(5) { false } }
    val call = mutableListOf<Int>()
    fun check(): Boolean {
        var count = 0
        for (i in bool) // 가로 검사
            if (i.all { it })
                count++
        for (i in bool.indices) // 세로 검사
            if (bool.map { it[i] }.all { it })
                count++
        if (bool.mapIndexed { index, booleans -> bool[index][index] }.all { it }) // 1부터 시작하는 대각선 검사
            count++
        if (bool.mapIndexed { index, booleans -> bool[index][5 - index - 1] }.all { it }) // 5부터 내려가는 대각선 검사
            count++
        return count >= 3
    }
    repeat(5) {
        graph.add(readln().split(" ").map { it.toInt() })
    }
    repeat(5) {
        readln().split(" ").forEach { call.add(it.toInt()) }
    }
    for (i in call.indices) {
        val row = graph.indexOfFirst { it.contains(call[i]) } // 열 찾기
        val col = graph[row].indexOf(call[i]) // 행 찾기
        bool[row][col] = true
        if (check()) {
            println(i + 1)
            break
        }
    }
}
