package com.kguard.tobecomebetter.baekjoon

import kotlin.math.max

// 골드 4 고층 건물
// 수학, 브루트포스 알고리즘, 기하학
// 기울기를 이용해서 문제를 해결해야 됨
// 기울기를 최대로 갱신해가며 문제를 해결해야됨
// 방법 1은 현재 위치를 기준으로 양옆으로 이동하며 기울기를 찾으며, 왼쪽으로 갈수록 기울기가 작아지고, 오른쪽으로 갈수록 기울기가 커져야 됨
// 방법 2는 현재 위치를 기준으로 오른쪽으로만 이동하며 기울기를 찾으며, 오른쪽으로 갈수록 기울기가 커져야 하며, 한쪽 건물에서 보이면 다른쪽 건물에서 보이는 것임
fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    var answer = 0
    val count = MutableList(n) { 0 }
    for (i in 0 until n) {
        // 방법 1. 왼쪽 오른쪽을 나눠서 푸는 방식
        var countT = 0 // 전체 카운트
        var inclineLeft = 0.0 // 0번째로 갈수록 보이기 위해서는 기울기가 점점 작아져야 됨
        for (left in i-1 downTo  0) { // 하나씩 이동해야 하니 현재 위치에서 가장 가까운 수부터 작아지도록 함
            val t = (list[i] - list[left]) / (i - left).toDouble() // 기울기 구하기
            if (t < inclineLeft || left == i-1) { // 현재 위치에서 가장 왼쪽에 있거나, 새로 구한 기울기가 이전 최소 기울기 보다 작으면 건물이 보이는 것임
                inclineLeft = t // 기울기 갱신
                countT++ // 카운트 추가
            }
        }

        var inclineRight = 0.0 // 마지막으로 갈수록 보이기 위해서는 기울기가 점점 커져야됨
        for (right in i + 1 until n) { // 하나씩 이동해야 하니 현재 위치에서 가장 가까운 수부터 커지도록 함
            val t = (list[i] - list[right]) / (i - right).toDouble() // 기울기 구하기
            if (t > inclineRight || right == i + 1) { // 현재 위치에서 가장 오른쪽에 있거나, 새로 구한 기울기가 이전 최대 기울기 보다 크면 건물이 보이는 것임
                inclineRight = t // 기울기 갱신
                countT++ // 카운트 추가
            }
        }
        answer = max(answer, countT) // 기존에 것들중 제일 큰것 선택

        // 방법 2 한쪽으로만 계산을해서 추가하는 방식
        var incline = Int.MIN_VALUE.toDouble() // 하나씩 이동할 수록 기울기가 계속 커져야 보이는 것
        for (j in i + 1 until n) { // 현재 위치 바로 오른쪽 부터 끝까지 실행 -> 한쪽에서 보이면 다른 족에서도 보이는 것임
            val t = (list[i] - list[j]) / (i - j).toDouble()
            if (t > incline) { // 새로 구한 기울기가 이전 최대 기울기 보다 크면 건물이 보이는 것이니 양쪽 건물에 보이는 건물 추가
                incline = t
                count[i]++ // 현재 위치에서 보이는 건물 개수 추가
                count[j]++ // 현재 위체에서 오른쪽에 있는 건물에서 현재 위치로 보이는 건물 추가
            }
        }
    }
//    println(count)
//    println(answer)
    println(count.max())
}