package com.kguard.tobecomebetter.baekjoon.kotlin

// 골드 2 새로운 게임 2
// 단순 시뮬레이션
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val map = mutableListOf<MutableList<Pair<Int, MutableList<Int>>>>()
    repeat(n) {
        val l = readln().split(" ").map { it.toInt() }.toMutableList()
        map.add(l.map { it to mutableListOf<Int>() }.toMutableList())
    }
    val horse = mutableListOf<MutableList<Int>>()
    val moveHeight = listOf(0, 0, -1, 1)
    val moveWidth = listOf(1, -1, 0, 0)

    repeat(k) {
        val (a, b, c) = readln().split(" ").map {num -> num.toInt() - 1 }.toMutableList()
        horse.add(mutableListOf(a, b, c))
        map[a][b].second.add(it)
    }
    var count = 0
    c@ while (count <= 1000) {
        count++
        for (id in 0 until k) {
            val i = horse[id]
            val oldY = i[0]
            val oldX = i[1]
            var ny = oldY + moveHeight[i[2]]
            var nx = oldX + moveWidth[i[2]]
            if (ny !in 0 until n || nx !in 0 until n || map[ny][nx].first == 2) {
                i[2] = i[2] xor 1
                ny = oldY + moveHeight[i[2]]
                nx = oldX + moveWidth[i[2]]
                if (ny !in 0 until n || nx !in 0 until n || map[ny][nx].first == 2)
                    continue
            }
            val stackIndex = map[oldY][oldX].second.indexOf(id)
            val newAdd = map[oldY][oldX].second.subList(stackIndex, map[oldY][oldX].second.size).toMutableList()
            when (map[ny][nx].first) {
                0 -> {
                    map[ny][nx].second.addAll(newAdd)
                    for (j in newAdd) {
                        horse[j][0] = ny
                        horse[j][1] = nx
                    }

                    map[oldY][oldX].second.subList(stackIndex, map[oldY][oldX].second.size).clear()

                }

                1 -> {
                    map[ny][nx].second.addAll(newAdd.reversed())
                    for (j in newAdd) {
                        horse[j][0] = ny
                        horse[j][1] = nx
                    }
                    map[oldY][oldX].second.subList(stackIndex, map[oldY][oldX].second.size).clear()
                }
            }
            if(map[ny][nx].second.size >= 4)
                break@c
        }

    }

    print(if(count >= 1000) -1 else count)

}