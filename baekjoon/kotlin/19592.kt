package com.kguard.tobecomebetter.baekjoon

import kotlin.math.floor

// 실버 5 장난감 경주
// 수학, 브루트포스 알고리즘, 이분 탐색
fun main() {
    repeat(readln().toInt()) {
        val (n, x, y) = readln().split(" ").map { it.toInt() }
        val v = readln().split(" ").map { it.toInt() }.toMutableList()
        val vi = v.removeAt(n - 1)
        var minTime = (x.toDouble() - y) / vi + 1 // 나올 수 있는 최대의 시간
        val min = x.toDouble() / v.max() // 이겨야 하는 최소 시간
        if (v.max() < vi) // 거리가 제일 크면 무조건 이김
            println(0)
        else if (minTime >= min) // 나올 수 있는 최소 시간 보다 이겨야 하는 최소 시간이 적으면 절대 못이김
            println(-1)
        else {
            // 이분탐색
            // upperBound : 찾으려는 값 보다 (초과한 값) 큰 값이 처음 나오는 위치 반환
            var left = 1
            var right = y
            var mid: Int
            while (left < right) {
                mid = (left + right) / 2
                if ((x - mid).toDouble() / vi + 1 >= min) // 중간 거리를 통해 구한 시간이 이겨야 하는 시간 보다 크면 -> 거리를 늘려서 시간을 단축 해야됨
                    left = mid + 1
                else
                    right = mid
            }
            println(right) // 최소거리 찾기

            // 수식으로 푼 문제
            println(floor(x - (min - 1) * vi).toInt() + 1)
        }
    }
}