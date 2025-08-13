package com.kguard.tobecomebetter.baekjoon

import kotlin.math.max

// 골드 4 알파벳
// 그래프 이론, 그래프 탐색, 깊이 우선 탐색, 백트래킹
// 백트래킹을 이용해서 모든 경우의 수를 돌도록 함 (자세한건 홈페이지 참고)
fun main() {
    val (r, c) = readln().split(" ").map { it.toInt() }
    var graph = Array(r) { readln() }
    var checkAlphabet = Array(26) { false } // 대문자 알파벳의 방문여부를 저장하는 리스트 -> 알파벳을 저장하는 것보다 방문 여부만 체크하는게 시간적으로 효율적임
    val moveHeight = arrayOf(1, -1, 0, 0) // 아래, 위로 이동 하는 부분
    val moveWidth = arrayOf(0, 0, 1, -1) // 오른쪽, 왼쪽으로 이동하는 부분
    var count = 0
    fun backtracking(y: Int, x: Int, cnt: Int) { // cnt는 방문한 길이
        if (cnt == r * c) { // 최대는 모든걸 돌았을
            count = cnt
            return
        }
        for (i in 0 until 4) {
            val ny = moveHeight[i] + y
            val nx = moveWidth[i] + x
            if (ny in 0 until r && nx in 0 until c && !checkAlphabet[graph[ny][nx].code - 65]) { // 알파벳 자체의 방문 여부만 확인, 문자열로 저장하면 찾는데 시간이 오래 걸림
                checkAlphabet[graph[ny][nx].code - 65] = true
                backtracking(ny, nx, cnt + 1)
                checkAlphabet[graph[ny][nx].code - 65] = false
            }
        }
        count = max(count, cnt) // 코드가 여기 까지 왔을때는 모든 방향을 방문한 경우
    }

    checkAlphabet[graph[0][0].code - 65] = true
    backtracking(0, 0, 1)
    print(count)
}