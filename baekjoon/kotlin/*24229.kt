package com.kguard.tobecomebetter.baekjoon.kotlin

import java.util.TreeSet

// 골드 4 모두싸인 출근길
// 그리디 적으로 풀면 됨 -> DP인척함
// 발판 겹치는 거 끼지 합치고
// 도움 닫기를 계산 -> 닿았다면 발판을 비교해서 갱신 및 해당 발판에서 갈 수 있는 최대 위치 계산
fun main() {
    val n = readln().toInt()
    val bridge = TreeSet<Pair<Int, Int>>(compareBy { it.first })
    repeat(n) {
        val (s, e) = readln().split(" ").map { it.toInt() }
        bridge.add(s to e)
    }

    val list = mutableListOf<Pair<Int, Int>>()
    var now = bridge.first() // 장판을 합치는 부분
    for (i in bridge.drop(1)) {
        if (now.second >= i.first)
            now = now.first to maxOf(now.second, i.second)
        else {
            list.add(now)
            now = i
        }
    }
    list.add(now)

    var totalMax = list[0].second // 최대 발판
    var canGo = list[0].second + (list[0].second - list[0].first) // 뛸 수 있는 최대 위치

    for (i in 1 until list.size) {
        // 현재 도움닫기로 갈 수 있다면
        if (list[i].first <= canGo) {
            // 닿았다면, 이 발판의 끝부분을 정답 후보로 등록
            totalMax = maxOf(list[i].second, totalMax)
            // 이 발판에서 새로 뛸 수 있는 최대 위치 계산해서 업데이트
            canGo = maxOf(canGo, list[i].second + (list[i].second - list[i].first))
        }

    }
    println(totalMax)

}