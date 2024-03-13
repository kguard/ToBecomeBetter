package com.kguard.tobecomebetter.baekjoon

//실버 3
// 00 타일 이나 1로 이루어진 것들
// 재활용을 사용해서 불필요한 자원 낭비 방지
// 피보나치 수열과 개수 같음

private var dp = mutableListOf<Int>()
fun main() {
    val n = readln().toInt()
    dp = MutableList(n + 2) { -1 }
    dp[0] = 0
    dp[1] = 1
    dp[2] = 2
    tile(n)
    println(dp[n])
//    tile2(n)
//    println(dp[n])
}
// 반복문으로 문제 푸는 방식
private fun tile(n: Int) {
    for (i in 3..n)
        dp[i] = (dp[i - 1] + dp[i - 2]) % 15746
}


// 재귀로 푸는 방식
private fun tile2(n: Int): Int {
    if (dp[n] == -1)
        dp[n] = (tile2(n - 1) + tile2(n - 2)) % 15746
    return dp[n]
}

