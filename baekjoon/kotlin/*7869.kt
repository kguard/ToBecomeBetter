package com.kguard.tobecomebetter.baekjoon

import kotlin.math.*

// 골드 2 두 원
// 수학, 기하학, 많은 조건 분기
// 졸라 어려움..
// 코사인 제2법칙을 사용해서 각도를 구하고, 부채꼴 넓이와 그 안에 삼각형의 넓이를 구해서 서로 뺀 값으로 문제를 해결
// 3가지의 경우의 수로 두 원이 서로 만나지 않을 때, 한 원이 다른 원 안에 존재 할때, 두 원이 서로 교차 할때 로 나눌 수 있음
// 두 원이 만나지 않으면 겹치는 부분은 0
// 한 원이 다른 원 안에 존재 하면 겹치는 부분은 더 작은 원의 넓이
// 두 원이 서로 교차 하면 (두 원의 교차하는 부채꼴 넓이의 합 - 부채꼴안에서 존재하는 삼각형 최대 넓이의 합)
fun main() {
    val list = readln().split(" ").map { it.toDouble() }
    val c1 = Triple(list[0], list[1], list[2])
    val c2 = Triple(list[3], list[4], list[5])
    val distance = hypot(c1.first - c2.first, c1.second - c2.second)
    if (distance >= c1.third + c2.third) {
        println("0.000")
    } else if (distance <= abs(c1.third - c2.third)) {
        val result = PI * min(c1.third, c2.third).pow(2)
        println(String.format("%.3f", result))
    } else {
        val theta1 = acos((distance * distance + c1.third * c1.third - c2.third * c2.third) / (2.0 * distance * c1.third)) * 2.0
        val theta2 = acos((distance * distance + c2.third * c2.third - c1.third * c1.third) / (2.0 * distance * c2.third)) * 2.0
        val result = (theta1 * c1.third * c1.third + theta2 * c2.third * c2.third - sin(theta1) * c1.third * c1.third - sin(theta2) * c2.third * c2.third) * 0.5
        println(String.format("%.3f", result))
    }
}