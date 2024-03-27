package com.kguard.tobecomebetter.baekjoon

import kotlin.math.max

// 실버 2
// 리스트의 시작점을 기점으로 큰것만 비교 하는것
// 중간에 큰 값이 있으면 숫자가 작아지게 됨
// 따라서 문제가 발생
//fun main() {
//    var result = 0
//    val n = readln().toInt()
//    val list = readln().split(" ").map { it.toInt() }
//    for (i in 0 until n) {
//        val dp = mutableListOf<Int>()
//        dp.add(list[i])
//        for (j in i + 1 until n) {  // 이 부분이 잘못되었음
//            if (dp.last() < list[j] )
//                dp.add(list[j])
//        }
//        if (dp.size > result)
//            result = dp.size
//    }
//    print(result)
//}

// 리스트의 값이 마지막일 때를 기즌으로 전(앞)의 값들을 세기
// 예시로 10 20 10 30 20 50 에서 [1]20 을 생각하면 [0]10 과 자기 자신을 포함해서 2개
fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val dp = MutableList<Int>(n) { 1 } // 자기 자신은 무조건 포함하기 때문에 1로 시작
    for (i in 0 until n) { // 마지막 값일때 기준
        for (j in 0 until i) { // 마지막 값일때 이니 작을때 까지
            if (list[i] > list[j]) // 마지막 값이 이전 값보다 클때 -> 갯수가 늘어야함
            {
                dp[i] = max(dp[i], dp[j] + 1) // 이미 포함된 숫자들을 포함 시키지 않기 위해서 길이 비교
            }
        }
    }
    print(dp.max())
}