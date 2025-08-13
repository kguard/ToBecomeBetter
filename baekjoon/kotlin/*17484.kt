package com.kguard.tobecomebetter.baekjoon

import kotlin.math.min

// 실버 3 진우의 달 여행 (Small)
// 다이나믹 프로그래밍(DP), 브루트포스 알고리즘
// 0이 7시 방향으로 내려온 거, 1이 6시 방향으로 내려온 거, 2가 5시 방향으로 내려온 거
// [i][j][l] : i와 j는 행과 열 l은 해당 행열의 값이 어디 방향에서 왔는지 확인
// dp를 사욯하는데 3방향에서 모두 올 수 있는 것을 저장하기 위해서 3차원 배열로 생성함
// 어려움..
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = mutableListOf<List<Int>>()
    repeat(n) { graph.add(readln().split(" ").map { it.toInt() }) }
    val dp = MutableList(n + 1) { MutableList(m + 1) { MutableList(3) { 1000 } } }
    for (i in 0 until m) {
        dp[0][i][0] = graph[0][i]
        dp[0][i][1] = graph[0][i]
        dp[0][i][2] = graph[0][i]
    }
    // 방법 1 ( 보기 쉽게 푼거)
    for (i in 1 until n)
        for (j in 0 until m) {
            if (j == 0) { // 시작일 때 -> 왼쪽 벽에 붙어 있으니 2번(5시 방향)에서 내려올 수 없음
                dp[i][j][0] = min(dp[i - 1][j + 1][2], dp[i - 1][j + 1][1]) + graph[i][j] // j+1 위치에서 내려와야지 0번 방향(7시 방향) 으로 내려온 것 -> j+1위치에서는 1번 방향(6시 방향)이나 2번 뱡향(5시 방향) 에서 내려와야 함
                dp[i][j][1] = dp[i - 1][j][0] + graph[i][j] // j 위치에서 내려와야지 1번 방향(6시 방향) 으로 내려 오려면 2번은 범위가 벗어나고, 1번은 중복이기 때문에 0번 방향(7시 방향)에서 내려와야함
            } else if (j == m - 1) { // 마지막 위치 -> 오른쪽 벽에 붙어 있으니 0번 방향(7시 방향) 에서 내려 올수 없음
                dp[i][j][2] = min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][0]) + graph[i][j] // 2번(5시 방향) 에서 내려오려면 j-1에서 내려와야 함 -> j-1에서 2번 방향에서 내려온게 아닌 것으로 선택
                dp[i][j][1] = dp[i - 1][j][2] + graph[i][j] // 1번(6시 방향) 에서 내려오려면 j에서 내려와야 하고, j는 0번 방향에서는 못내려오고, 1번(6시 방향)에서 내려온 것을 사용하면 중복이어서 2번(5시 방향)에서 내려 온거 여야 함
            } else { // 모든 방향에서 내려올 수 있을 때
                dp[i][j][0] = min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + graph[i][j]
                dp[i][j][1] = min(dp[i - 1][j][0], dp[i - 1][j][2]) + graph[i][j]
                dp[i][j][2] = min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + graph[i][j]
            }
        }
    println(dp[n-1].minOf { it.min() })

    // 방법 2 (코드 최소화)
    for (i in 1 until n)
        for (j in 0 until m)
            for (k in 0..2) {
                if ((j == 0 && k == 2) || (j == m - 1 && k == 0))  continue // 왼쪽 벽에 붙어 있고 2번(5시 방향) 에서 내려 오거나 오른쪽 벽에 붙어 있고 0번(7시 방향)에서 내려 오는 경우는 있을 수 없음
                for(l in 0..2) { // 3개가 다 만족 할때 -> 모든 방향에서 내려올 수 있을 때
                    if (k == l) continue // 같은 방향에서 내려올 수 없음
                    dp[i][j][k] = min(dp[i][j][k], dp[i-1][j-k+1][l] + graph[i][j]) // for문을 이용해서 계속해서 비교 하기  0 방향은 j+1, 1 방향은 j, 2 방향은 j-1
                }

            }
    println(dp[n-1].minOf { it.min() })
}