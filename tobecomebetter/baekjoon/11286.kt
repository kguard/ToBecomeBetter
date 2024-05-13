package com.kguard.tobecomebetter.baekjoon

import java.util.*
import kotlin.math.abs


// 실버 1
// 자료 구조, 우선 순위 큐
fun main() {
    val n = readln().toInt()
    val queue = PriorityQueue<Int>(compareBy<Int> { abs(it) }.thenBy { it })
    repeat(n) {
        val a = readln().toInt()
        if (a == 0) {
            if (queue.isEmpty())
                println(0)
            else
                println(queue.poll())
        } else {
            queue.add(a)
        }
    }
}