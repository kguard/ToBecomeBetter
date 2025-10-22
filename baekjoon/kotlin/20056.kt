package com.kguard.tobecomebetter.baekjoon.kotlin

// 골드 4 마법사 상어와 파이어볼
// 시뮬레이션 문제
fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    val fireball = mutableListOf<MutableList<Int>>()
    repeat(m) {
        val r = readln().split(" ").map { it.toInt() }.toMutableList()
        fireball.add(r)
    }
    val moveHeight = arrayOf(-1, -1, 0, 1, 1, 1, 0, -1)
    val moveWidth = arrayOf(0, 1, 1, 1, 0, -1, -1, -1)
    repeat(k) {
        // println(fireball)
        for (i in fireball) {
            i[0] = ((i[0] - 1 + moveHeight[i[4]] * i[3]) % n + n) % n + 1
            i[1] = ((i[1] - 1 + moveWidth[i[4]] * i[3]) % n + n) % n + 1
        }
        //   println(fireball)

        val group = fireball.groupBy { it[0] to it[1] }
        fireball.clear()
        group.forEach { (key, value) ->
            if (value.size >= 2) {
                val weight = value.sumOf { it[2] } / 5
                if (weight == 0)
                    return@forEach
                val speed = value.sumOf { it[3] } / value.count()
                val first = value[0][4] % 2
                val direction = value.all { it[4] % 2 == first }
                if (direction) {
                    repeat(4) { it ->
                        fireball.add(mutableListOf(key.first, key.second, weight, speed, it * 2))
                    }
                } else {
                    repeat(4) { it ->
                        fireball.add(mutableListOf(key.first, key.second, weight, speed, it * 2 + 1))
                    }
                }
            } else
                fireball.add(value[0])
        }

    }
    println(fireball.sumOf { it[2] })
}