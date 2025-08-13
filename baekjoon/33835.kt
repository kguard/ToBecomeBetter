package com.kguard.tobecomebetter.baekjoon

import kotlin.math.hypot

// 브론즈 1 도로 공사
// 수학, 애드 혹, 기하학
// 도로를 새로 건설 할 수 있으니 거리의 최소값은 두 도시를 바로 잇는 도로임
fun main() {
    val n = readln().toInt()
    val (a, b) = readln().split(" ").map { it.toDouble() }
    repeat(n - 2) { readln() }
    val (c, d) = readln().split(" ").map { it.toDouble() }
    print(hypot(a - c, b - d))
}