package com.kguard.tobecomebetter.baekjoon

import kotlin.math.min

// 골드 3 행렬 곱셈 순서
// 11066을 참고
// 2차원 배열을 만들어서 걸린 값과, 행렬 크기를 넣어줌

//fun main() {
//    val n = readln().toInt()
//    val list = mutableListOf<Pair<Int, Int>>()
//    val dp = MutableList(n) { MutableList(n) { Pair(0, Pair(0, 0)) } }
//    repeat(n) {
//        val (a, b) = readln().split(" ").map { it.toInt() }
//        list.add(Pair(a, b))
//    }
//    for (i in 0 until n - 1) { // 두번째 대각선에는 두개 뿐이니 두 행렬을 곱한 값과 곱한 행렬의 크기를 넣어줌
//        dp[i][i + 1] = mul(list[i], list[i + 1])
//    }
//    for(i in 0 until n) // 첫 번쩨 대각선에는 행렬이 하나이니 곱한 값은 0, 행렬 크기는 원래 자기 자신 크기
//        dp[i][i] = Pair(0,list[i])
//    for (k in 2 until n)  // (0,2) 부터 대각선 방향으로 반복
//        for (i in 0 until n - k) { // 열
//            val j = i + k // 행
//            var min = Int.MAX_VALUE
//            var pair : Pair<Int,Pair<Int,Int>> = Pair(0,Pair(0,0))
//            for(x in i until j){ // 두개의 행렬을 곱하는 모든 경우의 수
//                min = min(min,dp[i][x].first + dp[x+1][j].first + mul(dp[i][x].second,dp[x+1][j].second).first ) // 행렬의 최소값 구하기
//                pair = Pair(min, mul(dp[i][x].second,dp[x+1][j].second).second) // 행렬의 최소값과 그때의 행렬의 크기를 넣어줌
//            }
//            dp[i][j] = pair
//        }
//    println(dp[0][n-1].first)
//}
//
//private fun mul(a: Pair<Int, Int>, b: Pair<Int, Int>): Pair<Int, Pair<Int, Int>> { // 두개의 행렬을 곱하는 함수
//    return Pair(a.first * a.second * b.second, Pair(a.first, b.second))
//}

// 기본 리스트에 있는 행렬 사용
// 방법 자체는 위에와 동일
fun main(){
    val n = readln().toInt()
    val list = mutableListOf<Pair<Int, Int>>()
    val dp = MutableList(n) { MutableList(n) { 0 } }
    repeat(n) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        list.add(Pair(a, b))
    }
    for(k in 1 until n) // 대각선 방향으로 반복하기 위한 식 -> 열 마다 도달 할 수있는 행의 갯수 (0,1) 부터 시작
        for(i in 0 until n-k) { // 열
            val j = i + k // 행
            dp[i][j] = Int.MAX_VALUE
            for(x in i until j)
                // 곱할 두 행렬의 곱한 값들을 더한것 + 곱할 두 행렬의 값을 가져와서 곱셈 -> 2차원 배열과 원래 입력받은 행렬의 인덱스는 동일하여 이를 사용
                // 첫번째 행렬의 열 * 첫번째 행렬의 행 * 두번째 행렬의 행
                dp[i][j] = min(dp[i][j], dp[i][x] + dp[x+1][j]+list[i].first * list[x].second * list[j].second)
        }
    println(dp[0][n-1])
}