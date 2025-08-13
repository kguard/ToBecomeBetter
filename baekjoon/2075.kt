package com.kguard.tobecomebetter.baekjoon

import java.util.PriorityQueue

// 실버 3 N번째 큰 수
// 자료 구조, 정렬, 우선순위 큐
fun main() {
    val n = readln().toInt()
    val queue = PriorityQueue<Long>(reverseOrder<Long>())
    repeat(n) {
        queue.addAll(readln().split(" ").map { it.toLong() })
    }
    repeat(n - 1) { queue.remove() }
    var t = queue.remove()
    println(t)
}