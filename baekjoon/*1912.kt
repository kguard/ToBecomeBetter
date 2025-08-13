package com.kguard.tobecomebetter.baekjoon

import kotlin.math.max
// 실버 2
// n번까지의 연속합의 최대값은 [n-1번까지의 최대값 + n번 값] or [n번 값] 둘 중 큰 값이다.
// 배열에서 하나씩으로 보았을 때 최대 값을 비교
// (이전 배열에서의 합의 최대 값 + 현재 위치의 값) 과 (현재 위치의 값)을 비교해서 더 큰수를 넣으면 됨
fun main() {
    val n = readln().toInt()
    val num = readln().split(" ").map { it.toInt() }.toMutableList()
    val dp = MutableList(n) { -1001 }
    dp[0] = num[0]
    for (i in 1 until n) {
        dp[i] = max(dp[i - 1] + num[i], num[i])
    }
    print(dp)
}

