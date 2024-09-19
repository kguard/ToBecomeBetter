package com.kguard.tobecomebetter.baekjoon


import kotlin.math.*

// 골드 5 다각형의 면적
// 기하학, 다각형의 넓이
// 모든 다각형은 삼각형으로 나누어서 넓이를 구할 수 있음
// 신발끈 공식을 사용해서 문제를 해결
// 1 | x1 x2 x3 x1 |
// 2 | y1 y2 y3 y1 |
// 1/2 * abs((x1y2 + x2y3 + x3y1) - (y1x2 + y2x3 + y3x1 )) 의 방식으로 문제 해력
fun main() {
    val n = readln().toInt()
    val list = mutableListOf<Pair<Long, Long>>()
    repeat(n) {
        val (x, y) = readln().split(" ").map { it.toLong() }
        list.add(Pair(x, y))
    }
    list.add(list[0])
    var left = 0L
    var right = 0L
    for (i in 0 until n) {
        left += list[i].first * list[i + 1].second
        right += list[i].second * list[i + 1].first
    }
    val sum = abs(left - right) / 2.0
    println(String.format("%.1f", sum)) // 소수점 반올림에서 Long 타입은 문제가 생김
}
