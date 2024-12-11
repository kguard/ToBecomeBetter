package com.kguard.tobecomebetter.baekjoon

import kotlin.math.*

// 골드 3 소용돌이 예쁘게 출력하기
// 수학, 구현
// (0,0)을 중심으로 사각형을 그려서 레벨별로 따져서 숫자를 구하면 됨
// 레벨에 따라 8의 배수로 갯수가 증가하고, 레벨의 제일 마지막 숫자는 (2*레벨+1)의 제곱
// 각 꼭지점의 값은 시계방향으로 돌았을때 2*레벨 만큼의 차이가 남
// 소용돌이 그래프 안에서 숫자를 찾는 방식
// 1. 좌표에서 둘중 절대값이 더 큰 값을 레벨로 잡는다.
// 2. 레벨을 가지고 오른쪽 아랫 값 (레벨에서의 최대 값) 과 각 꼭짓점에서의 차이를 찾는다.
// 3. 오른쪽 아래에서 꼭지점의 값을 변경하는 방식으로 시계 방향으로 돌아가며 원하는 좌표가 사각형의 어느 쪽에 있는지 확인해서 값을 찾는다.
fun main() {
    val (r1, c1, r2, c2) = readln().split(" ").map { it.toInt() }
    val max = maxOf(spin(r1, c1), spin(r1, c2), spin(r2, c1), spin(r2, c2))
    for (y in r1..r2) {
        for (x in c1..c2) {
            val spin = spin(y, x)
            repeat(max.toString().length - spin.toString().length) { print(" ") }
            print("$spin ")
        }
        println()
    }
}

private fun spin(y: Int, x: Int): Int { // 소용돌이 그래프 안에서 숫자를 찾는 함수
    // 1. 좌표에서 둘중 절대값이 더 큰 값을 레벨로 잡는다.
    val level = max(abs(y), abs(x)) // (0,0)를 중심으로 사각형의 레벨 측정
    // 2. 레벨을 가지고 오른쪽 아랫 값 (레벨에서의 최대 값) 과 각 꼭짓점에서의 차이를 찾는다.
    var levelMax = (2.0 * level + 1).pow(2).toInt() // 현재 레벨에서의 최대 값 (오른쪽 아랫 값)
    val diff = 2 * level // 각 꼭지점의 수 차이

    // 3. 오른쪽 아래에서 꼭지점의 값을 변경하는 방식으로 시계 방향으로 돌아가며 원하는 좌표가 사각형의 어느 쪽에 있는지 확인해서 값을 찾는다.
    if (y == level) // 원하는 좌표의 수가 사각형 밑에 있는지 확인
        return levelMax - (level - x)
    levelMax -= diff // 왼쪽 아랫 값으로 이동
    if (x == -level) // 원하는 죄표의 수가 사각형 왼쪽에 있는지 확인
        return levelMax - (level - y)
    levelMax -= diff // 왼쪽 위 값으로 이동
    if (y == -level) // 원하는 좌표의 수가 사각형 위에 있는지 확인
        return levelMax - (level + x)
    levelMax -= diff // 오른쪽 위 값으로 이동
    return levelMax - (level + y) // 원하는 좌표가 사각형 오른쪽에 있는 것
}