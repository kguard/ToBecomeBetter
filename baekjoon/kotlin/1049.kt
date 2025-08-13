package com.kguard.tobecomebetter.baekjoon

import kotlin.math.min

// 실버 4 기타줄
// 수학, 그리디 알고리즘
// n의 갯수에 따라 계산함
// 1. n이 6개 적을 때
// 1.1 최소값 n개 사기
// 1.2 6개 짜리 하나 사기
// 2. n이 6개 보다 많을때
// 2.1 n개 사기
// 2.1 6개 짜리로만 사기 (n/6 + 1) * (최소값)
// 2.3 6개짜리 (n/6) 개랑, 나머지 n%6 개 사기
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val six = mutableListOf<Int>()
    val one = mutableListOf<Int>()
    var answer = Int.MAX_VALUE
    repeat(m) {
        val (s, o) = readln().split(" ").map { it.toInt() }
        six.add(s)
        one.add(o)
    }
    six.sort()
    one.sort()
    answer = if (n <= 6) {
        min(six[0], one[0] * n) // 낱개 n개 사기, 6개짜리 하나 사기
    } else {
        minOf(
            one[0] * n,
            (n / 6 + 1) * six[0],
            ((n / 6) * six[0]) + ((n % 6) * one[0])
        ) // 낱개 n개 사기, 6개 짜리 (n/6+1) 개 사기, 6개 짜리(n/6)개 사고, 나머지 (n%6)개 낱개로 사기
    }
    println(answer)
}