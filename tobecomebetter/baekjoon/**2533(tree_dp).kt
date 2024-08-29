package com.kguard.tobecomebetter.baekjoon

import kotlin.math.min

// 골드 3 사회망 서비스(SNS)
// 다이나믹 프로그래밍, 트리, 트리에서의 다이나믹 프로그래밍
// 2213과 같은 느낌으로 푸는 문제, 전형적인 트리 dp 문제
// 각 경우의 수는 독립적으로 작동하기 때문에 다이나믹 프로그래밍 사용
// 1. 본인이 일반인일 경우, 자식들은 모두 얼리 어답터 이어야만한다
// 2. 본인이 얼리어답터 일경우, 자식이 얼리 어답터가 아닐경우 와 얼리어답터일 경우 둘다 성립됨 -> 둘 중 작은 값을 선택하면 됨
fun main(){
    val n = readln().toInt()
    val graph = MutableList(n+1){ mutableListOf<Int>() }
    val dp = MutableList(n + 1) { mutableListOf(0, 0) } // 0 번째는 일반인일 경우, 1 번째는 얼리 어답터 일 경우
    val visited = MutableList(n + 1) { false }
    repeat(n-1){
        val (a,b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }
    fun dfs(s: Int){
        visited[s] = true
        dp[s][1] = 1 // 자신이 얼리 어답터 일경우 1명
        for(i in graph[s]){
            if(!visited[i]){
                dfs(i)
                dp[s][0] += dp[i][1] // 본인이 일반인일 경우, 자식들은 모두 얼리 어답터 이어야만한다
                dp[s][1] += min( dp[i][0], dp[i][1]) // 본인이 얼리어답터 일경우, 자식이 얼리 어답터가 아닐경우 와 얼리어답터일 경우 둘다 성립됨
            }
        }
    }
    dfs(1)
//    println(dp)
    println(dp[1].min())
}