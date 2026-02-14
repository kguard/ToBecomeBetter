package com.kguard.tobecomebetter.baekjoon.kotlin

import kotlin.math.max

// 실버 1 회전 초밥
// 슬라이딩 윈도우를 사용하는 문제
// 진짜 슬라이딩 윈도우가 아니라, 개수를 구하는 쪽으로 생각했어야 했음 -> % n 으로 순환 구조를 구현하는 게 맞다
// 처음에는 진짜 set으로 개수를 구했었음
fun main() {
    val (n, d, k, c) = readln().split(" ").map { it.toInt() }
    val plate = IntArray(n) { readln().toInt() }
    val count = IntArray(d + 1) // 현재 덱에 들어 있는 초밥 종류의 새수
    var current = 0 // 종류의 개수
    var max = 0

    for (i in 0 until k) { // 초기 세팅 -> K 개
        if (count[plate[i]] == 0) current++
        count[plate[i]]++
    }

    for (i in 0 until n) {
        max = max(max, if (count[c] == 0) current + 1 else current)

        count[plate[i]]--
        if (count[plate[i]] == 0) current--

        if (count[plate[(i + k) % n]] == 0) current++
        count[plate[(i + k) % n]]++

    }

    println(max)
}
