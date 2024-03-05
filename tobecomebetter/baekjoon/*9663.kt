package com.kguard.tobecomebetter.baekjoon

import kotlin.math.abs
// 골드 4
// n*n의 체스판을 인덱스와 들어가는 값을 통하여 2차원 배열 대신 표현
// 한 열에 하나의 퀸을 배치 후, 다음 열로 이동하여서 처음부터 확인, 마지막 열 까지 만족하면 sum+1, 아니면 다음 행으로 이동
private var chess = mutableListOf<Int>()
private var size = 0
private var sum = 0
fun main() {
    size = readln().toInt()
    chess = MutableList(size) { 0 }
    dfs(0)
    println(sum)
}

private fun check(level: Int): Boolean {
    for (i in 0 until level) // 이전 열들의 행과 이번 열의 행을 계속해서 비교
        if (chess[i] == chess[level] || abs(chess[level] - chess[i]) == level - i) return false // 같은 행에 있거나 대각선 상에 위치하면 false -> 같은 열에 있을 수 없음
    return true
}

private fun dfs(len: Int) {
    if (len == size) { // 마지막 까지 가면 종료
        sum++
        return
    }
    for (i in 0 until size) {
        chess[len] = i // len 번째 열의 i 번째 행
        if (check(len))
            dfs(len + 1)
    }
}