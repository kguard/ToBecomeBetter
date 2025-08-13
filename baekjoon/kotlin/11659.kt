package com.kguard.tobecomebetter.baekjoon

// 실버 3
// 누적 합을 사용해서 문제를 구하는 방법
// 전체 합들을 리스트에 저장하여 놓고, 합의 리스트에서 더 큰 구간 - (더 작은 구간 -1)으로 각 구간의 합들을 구할 수 있음
fun main() {
    val n = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }
    val sum = mutableListOf<Int>()
    sum.add(0)
    for (i in 0 until n[0])
        sum.add(sum[i] + list[i])
    repeat(n[1]) {
        val range = readln().split(" ").map { it.toInt() }
        println(sum[range[1]] - sum[range[0] - 1])
    }
}