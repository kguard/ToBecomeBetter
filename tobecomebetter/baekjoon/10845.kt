package com.kguard.tobecomebetter.baekjoon

// 실버 4 큐
// 자료 구조, 큐
fun main() {
    val queue = mutableListOf<Int>()
    val n = readln().toInt()
    repeat(n) {
        val c = readln().split(" ")
        when (c[0]) {
            "push" -> queue.add(c[1].toInt())
            "pop" -> if (queue.isEmpty()) println(-1) else println(queue.removeAt(0))
            "size" -> println(queue.size)
            "empty" -> if (queue.isEmpty()) println(1) else println(0)
            "front" -> if (queue.isEmpty()) println(-1) else println(queue[0])
            "back" -> if (queue.isEmpty()) println(-1) else println(queue[queue.lastIndex])
        }
    }
}