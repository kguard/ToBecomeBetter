package com.kguard.tobecomebetter.baekjoon
// 실버 3
// 그리드 알고리즘
// 순서에 연연하지 말고 처음 주유소를 최소 주유소로 만든다음
// 주유소 리스트를 돌면서 가장 작은 주유소를 찾음
// 가장 작은 주유소를 찾기 전까지는 그전까지의 최소 주유소에서 주유하기
// 너무 어렵게 생각함
fun main() {
    val n = readln().toInt()
    val distance = readln().split(" ").map { it.toLong() }
    val gas = readln().split(" ").map { it.toLong() }
    var cost = 0L
    var mingas = gas[0]
    for (i in 0 until n - 1) {
        if (mingas > gas[i]) {  // 최소인 주유소 찾기
            mingas = gas[i]
        }
        cost += mingas * distance[i] // 여태 까지의 최소의 주유소로 거리 더하기
    }
    println(cost)
}