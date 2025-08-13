package com.kguard.tobecomebetter.baekjoon

import kotlin.math.max

// 골드 5
// 전깃줄의 최소 개수 이니 전체 길이에서 가장 긴 수열을 빼면 됨
// a의 수로 정렬
// b에서 가장 긴 증가하는 부분을 구함
// b의 전체 사이즈 - 가장 긴 수열 - 1
fun main() {
    val n = readln().toInt()
    val dp = MutableList(n) { 0 }
    val list = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val t = readln().split(" ").map { it.toInt() }
        list.add(Pair(t[0], t[1]))
    }
    list.sortBy { it.first }
    for (i in 0 until n) {
        for (j in 0 until i) {
            if (list[i].second > list[j].second) {
                dp[i] = max(dp[i], dp[j] + 1)
            }
        }
    }
    print(dp.size - dp.max() - 1)
}