package com.kguard.tobecomebetter.baekjoon

// 실버 2
// 재귀에서 사용하기 저장 기능을 이용해서 사용
// 3차원 배열을 만들어서 값을 저장해 놓고 사용한다
private val dp = MutableList(21) { MutableList(21) { MutableList(21) { 0 } } }
fun main() {
    while (true) {
        val n = readln().split(" ").map { it.toInt() }
        if (n[0] == -1 && n[1] == -1 && n[2] == -1)
            return

        println("w(${n[0]}, ${n[1]}, ${n[2]}) = ${w(n[0], n[1], n[2])}")
    }
}

private fun w(a: Int, b: Int, c: Int): Int {
    return if (a <= 0 || b <= 0 || c <= 0) {
        1
    } else if (a > 20 || b > 20 || c > 20) {
        dp[20][20][20] = w(20, 20, 20)
        dp[20][20][20]
    } else if (dp[a][b][c] != 0) { // 여기서 값을 다시 계산히자 않고 저장되어 있는 값들을 불러옴
        dp[a][b][c]
    } else if (b in (a + 1)..<c) {
        dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c)
        dp[a][b][c]
    } else {
        dp[a][b][c] =
            w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1)
        dp[a][b][c]
    }
}