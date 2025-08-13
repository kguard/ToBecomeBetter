package com.kguard.tobecomebetter.baekjoon

import kotlin.math.min

//골드 5
// 바뀌어야 할 색들을 정해 놓고 이를 누적합을 통해서 문제 해결
// 따라사 바뀌어야할 부분에 숫자를 1, 안 바뀌어야할 부분의 숫자를 0으로 저장해 놓음
// 처음의 색이 검은색과 흰색 두가지의 경우의 수가 있기 때문에 둘다 구해서 비교
fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    val bBoard = Array(n) { MutableList(m) { 0 } }  // 첫 시작이 검은 색일 때 바뀌어야할 색(흰색)들은 1로 저장해 놓은 판
    val wBoard = Array(n) { MutableList(m) { 0 } } // 첫 시작이 흰 색 일때 바뀌어야할 색(검은색)들은 1로 저장해 놓은 판
    val bSum = Array(n + 1) { MutableList(m + 1) { 0 } } // 검은색 판의 누적 합
    val wSum = Array(n + 1) { MutableList(m + 1) { 0 } } // 흰색 판의 누적 합
    var count = 4000000
    for (i in 0 until n) {
        val list = readln().split("").toMutableList()
        list.removeFirst()
        list.removeLast()
        for (j in 0 until m) {
            if ((i + j) % 2 == 0) {  // 행 + 열이 짝수 일때 같은 색 이기 때문에 처음거와 색이 같으면 0, 아니면 1. 홀수 일때는 같으면 1 다르면 0
                if (list[j] == "B") { // 짝수 번째 일때 -> 같은 색이 들어와야함
                    bBoard[i][j] = 0 // 검은색이 들어오면 안바뀌어야 하니 0
                    wBoard[i][j] = 1 // 검은색이 들어왔을때 원래 흰색이 들어와야 하므로 바뀌어야 하니 1
                } else {
                    bBoard[i][j] = 1 // 흰색이 들어오면 바뀌어어야 하니 1
                    wBoard[i][j] = 0 // 흰색이 들어왔을때 안바뀌어야 하니 0
                }
            } else {  // 홀수 번쨰 일때 -> 다른 색이 들어와야 함
                if (list[j] == "B") {
                    bBoard[i][j] = 1 // 위에거 참조
                    wBoard[i][j] = 0
                } else {
                    bBoard[i][j] = 0
                    wBoard[i][j] = 1
                }
            }
        }
    }
    for (i in 1..n) { // 2차원 배열 누적 합을 구하는 부분
        for (j in 1..m) {
            bSum[i][j] = bBoard[i - 1][j - 1] + bSum[i - 1][j] + bSum[i][j - 1] - bSum[i - 1][j - 1]
            wSum[i][j] = wBoard[i - 1][j - 1] + wSum[i - 1][j] + wSum[i][j - 1] - wSum[i - 1][j - 1]
        }
    }
    for (i in 1..n - k + 1) { // 구간을 정해서 모든 구간에서 최댓값을 도출
        for (j in 1..m - k + 1) {
            val a = min(  // 처음이 검은색 일때와 흰색일 때를 비교해서 최소값 도출
                wSum[i + k - 1][j + k - 1] - wSum[i + k - 1][j - 1] - wSum[i - 1][j + k - 1] + wSum[i - 1][j - 1],
                bSum[i + k - 1][j + k - 1] - bSum[i + k - 1][j - 1] - bSum[i - 1][j + k - 1] + bSum[i - 1][j - 1]
            )
            count = min(a, count) // 이전의 최소 값과 지금의 최소값을 비교
        }
    }
    println(count)
}