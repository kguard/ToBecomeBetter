package com.kguard.tobecomebetter.baekjoon

import kotlin.math.*

// 실버 4 대피소
// 구현, 브루트포스 알고리즘, 시뮬레이션
// k의 범위가 1부터 3 까지임 -> 그냥 최대 4중 for문을 사용
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val home = mutableListOf<Pair<Int, Int>>()
    var min = 1000000
    repeat(n) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        home.add(Pair(x, y))
    }
    when (k) {
        1 -> {
            for (i in home.indices) {
                var max = 0
                for (j in home)
                    if (j != home[i])
                        max =
                            max(max, abs(home[i].first - j.first) + abs(home[i].second - j.second))
                min = min(max, min)
            }
        }

        2 -> {
            for (i in home.indices)
                for (j in i + 1 until n) {
                    var max = 0
                    for (k in home)
                        if (k != home[i] && k != home[j]) {
                            val dist = min(
                                abs(home[j].first - k.first) + abs(home[j].second - k.second),
                                abs(home[i].first - k.first) + abs(home[i].second - k.second)
                            )
                            max = max(max, dist)
                        }
                    min = min(max, min)
                }
        }

        3 -> {
            for (i in home.indices)
                for (j in i + 1 until n)
                    for (l in j + 1 until n) {
                        var max = 0
                        for (k in home)
                            if (k != home[i] && k != home[j] && k != home[l]) {
                                val dist = minOf(
                                    abs(home[j].first - k.first) + abs(home[j].second - k.second),
                                    abs(home[i].first - k.first) + abs(home[i].second - k.second),
                                    abs(home[l].first - k.first) + abs(home[l].second - k.second)
                                )
                                max = max(max, dist)
                            }
                        min = min(max, min)
                    }
        }
    }
    println(min)
}
