package com.kguard.tobecomebetter.baekjoon
private val dp = MutableList<Long>(101){0}
fun main(){
    dp[0] = 0
    dp[1] = 1
    dp[2] = 1
    dp[3] = 1
    dp[4] = 2
    dp[5] = 2
    wave()
    repeat (readln().toInt()){
        println(dp[readln().toInt()])
    }
}

private fun wave(){
    for(i in 6..100)
        dp[i] = dp[i-1] + dp[i-5]  // 점화식
}