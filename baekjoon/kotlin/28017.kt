package com.kguard.tobecomebetter.baekjoon.kotlin

// 골드 5 게임을 클리어하자
// dp 문제
// 각 경우에 수마다 제일 최소값, 제일 최소 값의 인덱스, 그 다음 최소값 을 구해야함
fun main(){
    val (n,m) = readln().split(" ").map { it.toInt() }
    val weapon = mutableListOf<List<Int>>()
    repeat(n){
        weapon.add(readln().split(" ").map { it.toInt() })
    }
    val dp = Array(n){Array(m){0} } // DP[i][j] = i번째 회차의 게임을 j번 장비를 선택해서 클리어했을 때까지 드는 최소 시간의 합
    for(j in 0 until m) {
        dp[0][j] = weapon[0][j]
    }
    for(i in 1 until n){
        var min1 = Int.MAX_VALUE
        var min2 = Int.MAX_VALUE
        var idx = -1
        for(j in 0 until m){
            if(dp[i-1][j] < min1){
                min2 = min1
                min1 = dp[i-1][j]
                idx = j
            }
            else if(dp[i-1][j] < min2){
                min2 = dp[i-1][j]
            }

        }
        for(j in 0 until m){
            if(j != idx){
                dp[i][j] = min1 + weapon[i][j]
            }
            else{
                dp[i][j] = min2 + weapon[i][j]
            }
        }
    }

    println(dp[n-1].min())
}
