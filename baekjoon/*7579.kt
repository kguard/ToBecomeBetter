package com.kguard.tobecomebetter.baekjoon

import kotlin.math.max

// 골드 3 앱
// 다이나믹 프로그래밍, 배낭 문제
// 앱 비활성화의 최소값을 구하려면 -> 메모리의 값이 최대 값인 것을 구하면 됨
// 총 비용이 순서대로 증가하면서 메모리가 주어진 값보다 크게 되면 -> 비용이 최소값인것임
// 메모리의 수와 총 비용으로 dp를 만들어서 계산 -> 내용으로는 메모리의 최대값을 넣음
// ex) 순서대로 메모리가 2개이고 총 비용이 5 개 일대의 메모리의 최대값
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val memory = readln().split(" ").map { it.toInt() }
    val cost = readln().split(" ").map { it.toInt() }
    val dp = MutableList(n) { MutableList(cost.sum() + 1) { 0 } }
    for (i in cost[0]..cost.sum()) // 메모리가 1개일때는, 그 메모리의 비용부터 끝까지 그 메모리용량으로 고정
        dp[0][i] = memory[0]

    for (i in 1 until n) // 메모리가 2개일때 부터 시작
        for (j in 0..cost.sum()) { // 최대 값은 비용의 합이 됨
            if (j - cost[i] >= 0) // 총 비용에서 현재 메모리의 비용을 뺏을 떄 0 보다 클 때 -> 현재 비용을 사용해도 남은 비용이 있을때
                dp[i][j] = max(dp[i][j], dp[i - 1][j - cost[i]] + memory[i]) // 현재 메모리 값 과 전 메모리 갯수에서 남은 비용의 최대 값 + 현재 메모리 -> (총 비용 - 현재 메모리의 비용) + 현재 메모리
            dp[i][j] = max(dp[i][j], dp[i - 1][j]) // 그 전 메모리에서의 최대 값과 비교
        }
    for(i in 0 .. cost.sum())
        if(dp[n-1][i]>=m) { // dp의 마지막 열에서 메모리가 주어진 값 보다 크게 되면 해당하는 비용 출력
            println(i)
            break
        }
}