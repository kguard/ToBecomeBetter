package com.kguard.tobecomebetter.baekjoon

import kotlin.math.*

// 골드 3 집으로
// 애드 혹(입력에 따른 해결 방법이 다른 것), 기하학, 많은 조건 분기
// 대각선으로도 이동 가능
// 여러 가지 경우의 수가 생김 -> 아래 참고
fun main() {
    val (x, y, d, t) = readln().split(" ").map { it.toInt() }
    val distance = hypot(x.toDouble(), y.toDouble())
    val jump = (distance / d).toInt()// 점프로 갈 수 있는 최대 횟수 -> 소수점 문제로 toInt() 사용
    if (distance >= d) { // 1. 총 거리가 한번 점프로 갈 수 있는 거리보다 크거나 같을 경우
        val walk = distance // 1-1. 그냥 걸어갈 경우
        val jumpWalk = jump * t + (distance % d) // 1-2. 최대한으로 점프 한 다음, 남은 거리를 걸어갈 경우
        val jumpPlusOne = (jump + 1.0) * t  // 1-3. 방향을 바꿔서 뛰면, 점프를 한번 더 할 경우, 무조건 도달 할 수 있음
        val r = min(walk, min(jumpWalk, jumpPlusOne))
        println(r)
    } else { // 2. 총 거리가 한번 점프로 갈 수 있는 거리보다 작은 경우
        val walk = distance // 2-1. 그냥 걸어갈 경우
        val jumpBack = t + (d - distance) // 2-2. 한번 점프하고 넘어간 거리 다시 돌아 오기
        val jumpPlusOne = t * 2.0 // 2-3. 방향을 바꿔서 뛰면, 점프를 한번 더 할 경우, 무조건 도달 할 수 있음
        val r = min(walk, min(jumpBack, jumpPlusOne))
        println(r)
    }
}