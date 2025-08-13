package com.kguard.tobecomebetter.baekjoon

import kotlin.math.min

// 골드3 파일 합치기
// 다이나믹 프로그래밍
// https://hseungyeon.tistory.com/313 참고
// 누적 합에 대한 2차원 배열을 만든 다음 -> 누적합으로 초기화 -> 각 열 마다 시작하는 누적합의 위치를 다르게 설정
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt();
        val file = readln().split(" ").map { it.toInt() }
        val dp = MutableList(n) { MutableList(n) { 0 } }
        for (i in 0 until n - 1) { // 누적합 으로 초기화 하는 과정 -> 각 열 마다 시작 위치가 다음
            dp[i][i + 1] = file[i] + file[i + 1] // 처음 부분에는 값이 없으니 초반 2개를 더한 것을 넣어줌
            for (j in i + 2 until n) {
                dp[i][j] = dp[i][j - 1] + file[j] // 다음 단계부터 이전 누적 값 + 새로운 값을 넣어서 누적합을 만듬
            }
        }
        for (k in 2 until n) // i를 하나씩 증가 시키기 위해서
            for (i in 0 until n - k) { // 높이를 먼저 증가 시킴 ex) 전체 길이가 4 이면 2까지만
                val j = i + k // j는 행을 뜻함, 가로 길이
                var min = Int.MAX_VALUE // 도달 하는 데 까지의 최소값
                for (x in i until j) // 최소값으로 도달할 수 있는 모든 경우의 수 구하기
                    min = min(dp[i][x] + dp[x + 1][j], min) // 원하는 장소까지의 최소 값은 어쨌든 두개의 값을 더해서 나온 결과이니, 어떤 두개를 선택할지 정하기
                dp[i][j] += min // 기본 누적합 + 거기까지의 최소 값
            }
        println(dp[0][n-1])
    }
}