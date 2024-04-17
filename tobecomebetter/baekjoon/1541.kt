package com.kguard.tobecomebetter.baekjoon

// 실버 2
// 그리드 알고리즘
// - 인 부분이 중요하기 때문에 + 부분을 먼저 구하기
fun main() {
    val list = readln().split("-")
    var sum = list[0].split("+").sumOf { it.toInt() }
    for (i in 1 until list.size) {
        sum -= list[i].split("+").sumOf { it.toInt() }
    }
    println(sum)
}