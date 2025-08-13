package com.kguard.tobecomebetter.baekjoon

import kotlin.math.abs
import kotlin.math.hypot

// 실버 3 어린 왕자
// 수학, 기하학
// 행성을 접하는 경우는 출발점이나 도착점이 원 내부에 있을때
// 출발점이나 도착점에서 원 중심 까지 거리가 반지름 보다 작으면 원 내부에 있는거
// 하지만 두 점이 모두 원 내부에 존재하면 원을 이탈/진입 할 필요가 없음
// 따라서 원을 진입/이탈 하려면 둘 중 하나면 원의 내부에 존재해야 됨
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (x1, y1, x2, y2) = readln().split(" ").map { it.toInt() }
        var count = 0
        val n = readln().toInt()
        repeat(n) {
            val (cx, cy, cr) = readln().split(" ").map { it.toInt() }
            val d1 = hypot(abs(x1 - cx).toDouble(), abs(y1 - cy).toDouble()) // 점1 과 원의 중심과의 거리
            val d2 = hypot(abs(x2 - cx).toDouble(), abs(y2 - cy).toDouble()) // 점2 와 원의 중심과의 거리
            if (d1 < cr && d2 > cr) // 점1이 원 내부에 있고, 점2는 원 외부에 있을 때
                count++
            else if (d1 > cr && d2 < cr) // 점1이 원 외부에 있고, 점2는 원 내부에 있을 때
                count++
        }
        println(count)
    }
}