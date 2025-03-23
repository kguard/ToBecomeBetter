package com.kguard.tobecomebetter.baekjoon

// 실버 3 나이트의 이동
// 애드 혹 (살짝 편법으로 푸는 느낌)  -> 문제에 함정이 있음
// 나이트는 2번씩 이동할 때 마다 같은 색상의 있는 모든 위치를 갈 수 있음
// 흑(시작) -> 백(1번) -> 흑(2번)
// 문제에서 원하는 연산은 2번의 움직임을 1개의 연산으로 취급함
// 따라서 n이 4이상인 모든
fun main() {
    val n = readln().toLong()
    val (r, c) = readln().split(" ").map { it.toInt() }
    if (n == 3L) { // n이 3개 일 경우
        if (r == 2 && c == 2) // 시작점이 한 가운데인 경우는 움직일 수 없음
            println(1)
        else
            println(4) // 가운데로 이동을 못하기 때문에 가장자리 8개 중 같은 색인 4개만 접근 가능
    } else {
        if (n % 2 == 1L) { // n이 홀수이면 흑과 백의 색의 갯수가 다름
            if ((r + c) % 2 == 1) // 짝수 위치에 있는 색이 홀수 위치에 있는 색보다 1개 더 많음
                println(n * n / 2) // 홀수 위치에 있는 색일 경우
            else
                println(n * n / 2 + 1) // 짝수 위치에 있는 색일 경우
        } else
            println(n * n / 2)
    }
}
