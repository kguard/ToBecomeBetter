package com.kguard.tobecomebetter.baekjoon

import java.util.PriorityQueue

// 실버 2
// 우선 순위 큐, 자료 구조
fun main() {
    val n = readln().toInt()
    val queue = PriorityQueue<Int>(reverseOrder()) // 최대 힙이므로 우선순위 큐에서 내림차순으로 정리
    repeat(n) {
        val a = readln().toInt()
        if (a > 0) queue.add(a)
        else {
            if (queue.isEmpty())
                println(0)
            else
                println(queue.poll())
        }
    }
    /*val list = mutableListOf<Int>()
    repeat(n) {
        val a = readln().toInt()
        if (a > 0) list.add(a) else {
            if (list.isEmpty())
                println(0)
            else {
                list.sort()
                println(list.removeLast())
            }
        }
    }*/
}