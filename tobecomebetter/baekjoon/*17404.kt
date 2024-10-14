package com.kguard.tobecomebetter.baekjoon

import kotlin.math.min

// 골드 4 RGB거리 2
// 다이나믹 프로그래밍
// 1149 문제에서 추가문제
// 1149번과 달리 1번과 N번도 각각 색이 겹치면 안됨
// 처음과 마지막 색을 정해 놓은 뒤 거기서 최소값을 구하는 방식으로 문제 해결
fun main() {
    val n = readln().toInt()
    val list = mutableListOf<MutableList<Int>>()
    repeat(n) {
        val r = readln().split(" ").map { it.toInt() }.toMutableList()
        list.add(r)
    }
    var ans  = Int.MAX_VALUE
    for (s in 0..2) { // 처음 색을 정하기 위한 반복문
        val dp = MutableList(n) { MutableList(3) { 10000 } } // 처음 색이 다 달라지기 때문에 새로 생성
        dp[0][s] = list[0][s] // 처음 색 저장
        for (i in 1 until n) { // dp를 사용해서 겹치지 않는 색 중 작은 값을 골라 넣기
            dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + list[i][0] // 그 현재 최소값은 이전에 겹치지 않는 색들 중 작은 값과 현재 값을 더한 값
            dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + list[i][1]
            dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + list[i][2]
        }
        for(l in 0 .. 2){ // 마지막 색을 정하기 위한 반복문
            if(s == l ) continue // 처음 색과 마지막 색이 겹치면 안되기 때문에 넘어감
            else ans = min(ans, dp[n-1][l]) // 안 겹칠시 최소 값 탐색
        }
    }
    println(ans)
}