package com.kguard.tobecomebetter.baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

// 골드 5
// lcs : Longest Common Substring와 Longest Common Subsequence
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val a = br.readLine()
    val b = br.readLine()
    val lcs = Array(a.length + 1) { Array(b.length + 1) { 0 } }
    for (i in 1..a.length) {
        for (j in 1..b.length) {
            if (a[i - 1] == b[j - 1]) {
                lcs[i][j] = lcs[i - 1][j - 1] + 1
            } else {
                lcs[i][j] = max(lcs[i - 1][j], lcs[i][j - 1])
            }
        }
    }
    println(lcs[a.length][b.length])
}

// 최장 공통 문자열 구하는 함수
// 2차원 배열을 이용해서 구하는 방식
// 두 문자열을 비교해서 문자가 다르면 0, 같으면 [i-1][j-1]+1을 저장 -> 연속되어야 하기 때문에
// 공통문자열은 연속되어야 하기 때문에 이전걸로 확인 해야됨

private fun lcSubstring(a: String, b: String): Int {
    val lcs = MutableList(a.length + 1) { MutableList(b.length + 1) { 0 } }
    for (i in 1..a.length) {
        for (j in 1..b.length) {
            if (a[i - 1] == b[j - 1]) {
                lcs[i][j] = lcs[i - 1][j - 1] + 1
            }
        }
    }

    return lcs.maxOf { it.max() }
}

// 최장 공통 부분 수열 구하는 함수
// 2차원 배열을 사용 -> 이전 문자열 비교 내용들을 저장해서 사용 연속 x
// 두 문자열을 비교해서 문자가 다르면 [i-1][j] 나 [i][j-1]중 큰것, 같으면 [i-1][j-1]+1을 저장
// 다를 때 [i-1][j] 나 [i][j-1]중 큰것을 쓰는 이유는 이전 문자열들을 비교 한 내용을 저장하기 때문에 저장
private fun lcSubsequence(a: String, b: String): Int {
    val lcs = MutableList(a.length + 1) { MutableList(b.length + 1) { 0 } }
    for (i in 1..a.length) {
        for (j in 1..b.length) {
            if (a[i - 1] == b[j - 1]) {
                lcs[i][j] = lcs[i - 1][j - 1] + 1
            } else {
                lcs[i][j] = max(lcs[i - 1][j], lcs[i][j - 1])
            }
        }
    }
    return lcs[a.length][b.length]
}