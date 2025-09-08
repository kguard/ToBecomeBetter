package com.kguard.tobecomebetter.baekjoon.kotlin

// 골드 1 달이차오른다, 가자
// BFS, 비트 마스킹
// visited 배열을 3차원으로 설정해서 key를 가지고 있는 경우를 다 다른 경우 로 생각해 줘야함
// 이때 키 가지고 있는 것을 비트마스킹을 사용
// 모든 키를 다 탐색하기 위해서 [N][M][64]로 설정
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = mutableListOf<MutableList<Char>>()
    repeat(n) { map.add(readln().toMutableList()) }
    val start = map.indices.firstNotNullOf { row ->
        map[row].indexOf('0').takeIf { it != -1 }?.let { col -> row to col }
    }
    val v = Array(n) { Array(m) { BooleanArray(64) { false } } }

    val moveHeight = listOf(-1, 1, 0, 0)
    val moveWidth = listOf(0, 0, -1, 1)

    val q = ArrayDeque<MutableList<Int>>()
    q.add(mutableListOf(start.first, start.second, 0, 0))
    v[start.first][start.second][0] = true
    var result = -1
    RoopQ@ while (q.isNotEmpty()) {
        val poll = q.removeFirst()
        for (i in 0 until 4) {
            val ny = poll[0] + moveHeight[i]
            val nx = poll[1] + moveWidth[i]
            var key = poll[2]
            val count = poll[3]

            if (ny !in 0 until n || nx !in 0 until m || map[ny][nx] == '#')
                continue
            else if (map[ny][nx] == '1') {
                result = count + 1
                break@RoopQ
            } else if (map[ny][nx].isUpperCase() && key and (1 shl ((map[ny][nx] - 65).code)) == 0)
                continue
            else if (map[ny][nx].isLowerCase())
                key = key or (1 shl (map[ny][nx] - 97).code)


            if (!v[ny][nx][key]) {
                v[ny][nx][key] = true
                q.add(mutableListOf(ny, nx, key, count + 1))
            }

        }
    }
    print(result)
}