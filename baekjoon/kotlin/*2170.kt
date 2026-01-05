package com.kguard.tobecomebetter.baekjoon.kotlin

import kotlin.math.max
// 골드 5 선 긋기
// 스와핑 알고리즘 : 데이터를 한쪽 방향에서부터 차례대로 훑어가며 문제를 해결하는 기법
// 시작점을 기준으로 정렬 한 다음, 겹치면 뒤로 추가하고, 아니면 선 정산하고 새로운 선으로 생성
// 아 이걸 왜 생각 못했지
fun main() {
    val n = readln().toInt()
    val lines = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        lines.add(readln().split(" ").map { it.toInt() }.let { (a, b) -> a to b })
    }
    lines.sortBy { it.first } // 정렬
    var total = 0L
    var currentFirst = lines[0].first // 첫번째 시작점
    var currentSecond = lines[0].second // 첫번재 끝점

    for (i in 1 until n) {
        if (lines[i].first <= currentSecond) { // 겹치는 경우 -> 나중번째의 시작점이 현재의 끝점 보다 작거나 같으면 겹치는 것
            currentSecond = max(currentSecond, lines[i].second) // 끝점 정하기 현재의 끝점과 두번째의 끝점 중 큰거
        } else { // 겹치지 않는 경우 -> 정렬 되어 있는 상태이기 떄문에 나보다 뒤에 있을 수 밖에 없음
            total += (currentSecond - currentFirst) // 정산해버림
            currentFirst = lines[i].first
            currentSecond = lines[i].second
        }
    }
    total += (currentSecond - currentFirst)
    println(total)
}