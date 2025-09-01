package com.kguard.tobecomebetter.baekjoon

import kotlin.math.pow

// 골드 5 Z
// 분할정복, 재귀
fun main() {
    val (n, r, c) = readln().split(" ").map { it.toInt() }
    var ans = 0
    fun check(y: Int, x: Int, size: Int) { // y와 x는 시작점을 의미
        if (y == r && x == c) { // 원하는 좌표가 나왔을 때 출력
            println(ans)
            return
        } else if (r in y until y + size && c in x until x + size) { // 찾으려는 숫자가 원하는 사분면에 존재하는 경우
            check(y, x, size / 2) // 1사분면
            check(y, x + size / 2, size / 2) // 2사분면
            check(y + size / 2, x, size / 2) // 3사분면
            check(y + size / 2, x + size / 2, size / 2) // 4사분면
        } else // 존재하지 않으면 사각형의 사이즈를 더함으로써 그부분은 넘어가도록 함
            ans += size * size
    }
    check(0, 0, 2.0.pow(n).toInt())
}