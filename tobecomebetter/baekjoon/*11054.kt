package com.kguard.tobecomebetter.baekjoon

import kotlin.math.*

// 골드 4
// 11053번에서 감소 부분이 추가 된 것
// 감소하는 부분은 배열을 뒤집어서 반대 방향으로 증가하는 부분을 구함
// 증가하는 부분은 11053과 동일
// 증가하는 부분을 저장한 배열과 감소하는 부분을 저장한 배열을 뒤집어서 더하고 하나가 중복되니 -1

//fun main() {
//    val n = readln().toInt()
//    val list = readln().split(" ").map { it.toInt() }
//    val rList = list.reversed()
//    val dpUp = MutableList(n) { 1 }
//    val dpDown = MutableList(n) { 1 }
//    val dp = MutableList(n) { 0 }
//    for (i in 0 until n) {
//        for (j in 0 until i) {
//            if (list[i] > list[j]) {
//                dpUp[i] = max(dpUp[i], dpUp[j] + 1)
//            }
//            if (rList[i] > rList[j]) {
//                dpDown[i] = max(dpDown[i], dpDown[j] + 1)
//            }
//        }
//    }
//    for (i in 0 until n)
//        dp[i] = dpUp[i] + dpDown[n - i - 1] - 1
//    println(dp.max())
//}

// 감소하는 부분을 거꾸로 계산
fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val dpUp = MutableList(n) { 1 }
    val dpDown = MutableList(n) { 1 }
    val dp = MutableList(n) { 0 }
    for (i in 0 until n) {
        for (j in 0 until i) {
            if (list[i] > list[j]) {
                dpUp[i] = max(dpUp[i], dpUp[j] + 1)
            }
        }
    }
    for (i in n - 1 downTo 0) {
        for (j in n - 1 downTo i) {
            if (list[i] > list[j]) {
                dpDown[i] = max(dpDown[i], dpDown[j] + 1)
            }
        }
    }
    for (i in 0 until n)
        dp[i] = dpUp[i] + dpDown[i] - 1
    println(dp.max())
}