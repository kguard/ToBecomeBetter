package com.kguard.tobecomebetter.baekjoon

import kotlin.math.*

// 골드 3 두 배
// 수학, 그리디 알고리즘
// 리스트에 2를 계속 곱하면 오버플로우가 발생 -> log를 이용해서 문제 해결
fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toLong() }.toMutableList()
    var count = 0L
    val log = MutableList(n) { 0L } // 로그 값을 저장할 함수
    for (i in 1 until n) { // 1부터 시작
        val a = ceil(log2(list[i - 1].toDouble()) - log2(list[i].toDouble())).toLong() // i-1번째와 i번째의 log2값을 각각 구해서 차이를 찾고, 올림을 해줌
        val temp = a + log[i - 1] // 이전 로그 값을 더하는 이유는 i-1 번째는 이미 log[i-1]만큼 2를 곱했기 때문에, 위에서 구한 a에다 log[i-1]을 더해서 2를 곱할 횟수를 구함
        if (0 < temp) { // temp가 0보다 커야지 2를 곱할 수 있음
            log[i] = temp
            count += log[i]
        }
    }
    println(log)
    print(count)
}