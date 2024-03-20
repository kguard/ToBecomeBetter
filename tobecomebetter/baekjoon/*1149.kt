package com.kguard.tobecomebetter.baekjoon

import kotlin.math.min

// 실버 1
// 위에서 부터 작은 것만 찾아서 더하기
// 각 위치에 최대값을 저장하는 list 만들기
// 각 경우의 수를 모두 구해야됨
// 그 위치의 0 번째 값은 전 위치의 1번째 값과 2번째 값중 작은 값을 골라 그 위치의 0번째 값을 더한것

fun main() {
    val n = readln().toInt()
    val dp = mutableListOf<MutableList<Int>>()
    val sums = MutableList(n) { MutableList(3) { 0 } }
    repeat(n)
    {
        dp.add(readln().split(" ").map { it.toInt() }.toMutableList())
    }
    sums[0] = dp[0]
    for (i in 1 until n) {
        sums[i][0] =
            min(sums[i - 1][1], sums[i - 1][2]) + dp[i][0] // 그 전까지의 합들중 작은거 와 그 열,행 의 값과 더하기
        sums[i][1] = min(sums[i - 1][0], sums[i - 1][2]) + dp[i][1]
        sums[i][2] = min(sums[i - 1][0], sums[i - 1][1]) + dp[i][2]
    }
    println(sums[n - 1].min())
}