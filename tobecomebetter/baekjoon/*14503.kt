package com.kguard.tobecomebetter.baekjoon

// 골드 5 로봇 청소기
// 구현, 시뮬레이션
// dfs를 이용해서 문제를 해결, 생각 하지 못했음
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val (r, c, d) = readln().split(" ").map { it.toInt() }
    val room = mutableListOf<MutableList<Int>>()
    val moveHeight = mutableListOf(-1, 0, 1, 0) // 위, 아래로 이동 하는 부분
    val moveWidth = mutableListOf(0, 1, 0, -1) // 왼쪽, 오른쪽 으로 이동하는 부분
    repeat(n) {
        room.add(readln().split(" ").map { it.toInt() }.toMutableList())
    }
    var count = 1
    room[r][c] = -1
    fun dfs(y: Int, x: Int, dir: Int) {
        // 4방향으로 움직였을때 0이 있는지 확인
        for (i in 0..3) {
            val next = (dir + 3 - i) % 4 // 왼쪽 방향으로 이동
            val ny = y + moveHeight[next]
            val nx = x + moveWidth[next]
            if (ny in 0 until n && nx in 0 until m && room[ny][nx] == 0) {
                room[ny][nx] = -1
                count++
                dfs(ny, nx, next)
                return
            }
        }
        // 4방향에 움직였을때 0이 없을 경우 -> 다시 뒤로 돌아가야 함
        val back = (dir + 2) % 4 // 반대 방향으로 이동
        val by = y + moveHeight[back]
        val bx = x + moveWidth[back]
        if (by in 0 until n && bx in 0 until m && room[by][bx] != 1) // 벽이 아니여야 함
            dfs(by, bx, dir)
    }
    dfs(r, c, d)
    println(count)
}