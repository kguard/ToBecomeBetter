package com.kguard.tobecomebetter.baekjoon.kotlin

import java.util.PriorityQueue
import kotlin.math.abs

// 골드 5 근성아 일하자
// 우선순위 큐를 사용해서 문제를 해결
// 현재 문제 기준 작은 것과 큰 것들의 큐를 사용
// 작은 건 내림차순으로 정렬
fun main() {
    val n = readln().toInt()
    val smaller = PriorityQueue<Long>(reverseOrder())
    val bigger = PriorityQueue<Long>()
    var now = 0L
    var dist = 0L
    repeat(n) {
        val q = readln().split(" ")
        if (q[0].toInt() == 1) {
            if (q[1].toInt() <= now)
                smaller.add(q[1].toLong())
            else
                bigger.add(q[1].toLong())
        } else {
            while (smaller.isNotEmpty() || bigger.isNotEmpty()) {
                if (bigger.isEmpty()) {
                    val poll = smaller.poll()
                    dist += abs(now - poll)
                    now = poll
                } else if (smaller.isEmpty()) {
                    val poll = bigger.poll()
                    dist += abs(poll - now)
                    now = poll
                } else {
                    if (abs(smaller.peek() - now) <= abs(bigger.peek() - now)) {
                        val poll = smaller.poll()
                        dist += abs(now - poll)
                        now = poll
                    } else {
                        val poll = bigger.poll()
                        dist += abs(poll - now)
                        now = poll
                    }
                }
            }

        }
    }
    println(dist)
}