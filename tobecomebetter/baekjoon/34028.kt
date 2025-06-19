package com.kguard.tobecomebetter.baekjoon

// 브론즈 1 우리의 다정한 계절 속에(Seasons of Memories)
// 수학, 구현, 애드 혹, 사칙연산
fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    var count = (a - 2015) * 4
    count += when (b) {
        in 1..2 -> 1
        in 3..5 -> 2
        in 6..8 -> 3
        in 9..11 -> 4
        12 -> 5 // 12월은 1번의 겨울을 더 지내게 됨
        else -> 0
    }
    println(count)
}