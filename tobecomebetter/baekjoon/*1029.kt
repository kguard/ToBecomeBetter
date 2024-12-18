package com.kguard.tobecomebetter.baekjoon

import kotlin.math.*

// 골드 1 그림 교환
// 다이나믹 프로그래밍, 비트마스킹, 비트필드를 이용한 다이나믹 프로그래밍, (dfs)
// 2098번 문제와 비슷하게 풀이 하기
// dp 에는 사람 수 저장하는 리스트
// 각 자리를 비트로 하여서 계산
fun main() {
    val n = readln().toInt()
    val list = mutableListOf<List<Int>>()
    repeat(n) {
        val a = readln().split("").toMutableList()
        a.removeAt(0)
        a.removeAt(a.lastIndex)
        list.add(a.map { it.toInt() })
    }

    val dp = MutableList(n) { MutableList(1 shl n) { 0 } } // 최대 사람수를 저장할 2차원 배열
    fun dfs(now: Int, visited: Int, price: Int): Int { // now는 현재 그림을 파는 사람, visited는 여태 만났던 사람들의 위치를 비트에 추가한 것, price는 최대 금액
        if (dp[now][visited] != 0) return dp[now][visited] // 0이 아니면 값 리턴
        for (i in 1 until n) { // 각 줄의 모든 것을 확인
            if(now != i && list[now][i] >= price && (visited and (1 shl i) == 0))
                dp[now][visited] = max(dp[now][visited], 1 + dfs(i, visited or (1 shl i), list[now][i]))
//            if (now == i || list[now][i] < price || (visited and (1 shl i)) == 1 shl i) // 자기자신에서 살수 없고, 가격이 같거나 더 커야하고, 이미 지나온 자리가 아니여야 됨
//                continue
//            dp[now][visited] = max(dp[now][visited], 1 + dfs(i, visited or (1 shl i), list[now][i])) // 가격은 최대값으로 바뀌고, 사람 수 추가한것과 현재값 비교
        }
        return dp[now][visited]
    }
    println(dfs(0, 0, 0)+1) // 맨 처음 사람도 포함 시켜야 하기 때문에 +1을 함
}