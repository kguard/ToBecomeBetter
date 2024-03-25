package com.kguard.tobecomebetter.baekjoon

// 자릿 수에 대한 전체 개수로 세려고 하였음
//fun main() {
//    val n = readln().toInt()
//    val dp = MutableList<Long>(100) { 0 }
//    dp[0] = 9
//    for (i in 1 until 100) {
//        dp[i] = ((2 * dp[i - 1]) - ((i/2)+1)) % 1000000000
//    }
//    println(dp[n-1])
//}


// dp[자릿 수][첫번째 값] 을 적용 시켜서 2차원 배열
fun main() {
    val n = readln().toInt()
    val dp = MutableList<MutableList<Long>>(n + 1) { MutableList(10) { 0 } }
    for (i in 1..9) {
        dp[1][i] = 1  // 첫번째 자릿수는 무조건 1개
    }
    for (i in 2..n) { // 입력 받은 자릿수 까지 저장
        dp[i][0] = dp[i - 1][1] // 마지막 값이 0인 경우에는 전 자릿 수의 1인 경우 일때 밖에 없음
        dp[i][9] = dp[i - 1][8] // 마지막 값이 9인 경우에는 전 자릿 수의 8인 경우 일때 밖에 없음
        for (j in 1..8) {
            dp[i][j] =
                (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000 // 마지막 값이 1에서 8사이는 계단 식이기 때문에 (전 자릿 수의 이전값 + 전 자릿 수의 다음값)을 더하면 됨
        }
    }
    println(dp[n].sum() % 1000000000)
}