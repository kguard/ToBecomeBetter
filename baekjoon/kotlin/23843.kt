package com.kguard.tobecomebetter.baekjoon.kotlin

import java.util.PriorityQueue
// 골드 5 콘센트
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val t = readln().split(" ").map { it.toInt() }.sortedDescending()

    if (m >= n) {
        println(t.first())
        return
    }
    val queue = PriorityQueue<Int>()
    repeat(m) { it ->
        queue.add(t[it])
    }
    for (i in m until n) {
        val poll = queue.poll()
        queue.add(poll + t[i])
    }
    println(queue.max())

}