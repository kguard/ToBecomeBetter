package com.kguard.tobecomebetter.baekjoon

import kotlin.math.max
// 실버 3
// 누적 합을 이용해서 구하는 문제
// 누적합에서 빼면됨
// -100 이 100000 개 일수 있기 때문에 최소값 -10000000 으로 설정
fun main() {
    val n = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }
    var s = -10000000
    val sum = mutableListOf<Int>()
    sum.add(0)
    for (i in 0 until n[0])
        sum.add(sum[i] + list[i])
    for(i in n[1] .. n[0])
        s = max(s, sum[i]-sum[i-n[1]])
    println(s)
}