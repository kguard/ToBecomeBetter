package com.kguard.tobecomebetter.baekjoon

import kotlin.math.abs

// 골드 3 양팔저울
// 다이나믹 프로그래밍, 배낭 문제(냅색 문제)
// 추를 이용해서 만들 수 있는 구슬의 무게 와 추의 갯수를 이용해서 2차원 배열 생성
fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val m = readln().toInt()
    val check = readln().split(" ").map { it.toInt() }
    val dp = MutableList(n) { MutableList(list.sum() + 1) { false } } // 세로 값은 추의 무게, 가로 값은 0 부터 찾고 싶은 구슬의 마지막 값 까지
    for (i in 0 until n) {
        dp[i][0] = true
        dp[i][list[i]] = true
    }
    for (i in 1 until n) { // 추의 배열 을 뜻함 0 번째는 어쩌피 하나이니 1부터 시작
        for (j in 1..list.sum()) { // 만들수 있는 구슬의 값
            if (dp[i - 1][j]) { // 전에 추로 만들 수 있는 구슬의 값이면
                dp[i][j + list[i]] = true // 전에 추로 만들 수 있는 구슬의 값 + 지금의 추의 값 을 만들 수 있음
                dp[i][abs(j - list[i])] = true // 전에 추로 만들 수 있는 구슬의 값 - 지금의 추의 값 을 만들 수 있음
                dp[i][j] = true // 전에 추로 만들 수 있는 구슬의 값을 그대로 만들 수 있음
            }
        }
    }
    for (i in check) {
        if (i <= list.sum() && dp[n - 1][i])
            print("Y ")
        else
            print("N ")
    }
}