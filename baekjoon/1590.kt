package com.kguard.tobecomebetter.baekjoon

// 실버 4 캠프가는 영식
// 수학, 브루트포스 알고리즘, 이분 탐색
fun main() {
    val (n, t) = readln().split(" ").map { it.toInt() }
    val time = mutableListOf<Int>()
    repeat(n) {
        val (s, i, c) = readln().split(" ").map { it.toInt() }
        time.add(lowerBound(t, s, i, c - 1)) // 맨 처음에 시작하는 한대도 포함
    }
    time.removeAll(listOf(-1))
    if (time.isEmpty())
        println(-1)
    else
        println(time.min())
}

// 출발 시간이 같은 경우도 있기 때문에 lowerBound(찾는 값보다 크거나 같을 경우)로 진행
private fun lowerBound(t: Int, s: Int, i: Int, c: Int): Int {
    var left = 0
    var right = c
    var mid: Int
    if (t > s + i * c)
        return -1
    while (left < right) {
        mid = (left + right) / 2
        if (mid * i + s < t)
            left = mid + 1
        else
            right = mid
    }
    return (s + i * right) - t
}