package com.kguard.tobecomebetter.baekjoon


import kotlin.math.max

// 골드 4 LCS2
// LCS(Longest Common Subsequence, 최장 공통 부분 수열)
// 다이나믹 프로그래밍(dp)
// 9251의 연장선의 문제 -> 재귀를 이용해서 출력
// 두 문자열을 비교해서 문자가 다르면 [i-1][j] 나 [i][j-1]중 큰것, 같으면 [i-1][j-1]+1을 저장 -> 뒤쪽으로 계속해서 이어가야해서
// 다를 때 [i-1][j] 나 [i][j-1]중 큰것을 쓰는 이유는 이전 문자열들을 비교 한 내용을 저장하기 때문에 저장
fun main() {
    val a = readln()
    val b = readln()
    val dp = Array(a.length + 1) { Array(b.length + 1) { 0 } }
    for (i in 1..a.length) {
        for (j in 1..b.length) {
            if (a[i - 1] == b[j - 1]) { // 순서대로 지나가며 같으면
                dp[i][j] = dp[i - 1][j - 1] + 1 // 전 길이 +1
            } else {
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]) // 왼쪽과 위쪽 부분을 그대로 가져옴
            }
        }
    }
    // 이론상 역순으로 탐색하며 출력하는 과정
    fun print(i: Int, j: Int) {
        if (dp[i][j] == 0) return
        if (a[i - 1] == b[j - 1]) {
            print(i - 1, j - 1)
            print(a[i - 1])
        } else {
            if (dp[i - 1][j] > dp[i][j - 1])
                print(i - 1, j)
            else
                print(i, j - 1)
        }
    }
    println(dp[a.length][b.length])
    print(a.length, b.length)
}


// 메모리 초과
// dp 자체를 String 배열로 만들어서 String 배열안에 부분 수열을 추가
//fun main() {
//    val a = readln()
//    val b = readln()
//    val dp = MutableList(a.length + 1) { MutableList(b.length + 1) { "" } }
//    for (i in 1..a.length)
//        for (j in 1..b.length) {
//            if (a[i-1] == b[j-1]) {
//                dp[i][j] = dp[i - 1][j - 1] + a[i-1]
//            }
//            else {
//                if (dp[i - 1][j].length >= dp[i][j - 1].length)
//                    dp[i][j] = dp[i - 1][j]
//                else
//                    dp[i][j] = dp[i][j - 1]
//            }
//
//        }
//    dp.forEach { println(it) }
//    println(dp[a.length][b.length].length)
//    print(dp[a.length][b.length])
//}


