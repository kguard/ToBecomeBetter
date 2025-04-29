package com.kguard.tobecomebetter.baekjoon

// 실버 4 덱
// 구현, 자료 구조, 덱
// MutableList로도 해결가능
fun main() {
    val deque = ArrayDeque<Int>()
    val n = readln().toInt()
    repeat(n) {
        val read = readln().split(" ")
        when (read[0]) {
            "push_front" -> {
                deque.addFirst(read[1].toInt())
            }

            "push_back" -> {
                deque.addLast(read[1].toInt())
            }

            "pop_front" -> {
                if (deque.isEmpty()) println(-1) else println(deque.removeFirst())
            }

            "pop_back" -> {
                if (deque.isEmpty()) println(-1) else println(deque.removeLast())
            }

            "size" -> {
                println(deque.size)
            }

            "empty" -> {
                if (deque.isEmpty()) println(1) else println(0)
            }

            "front" -> {
                if (deque.isEmpty()) println(-1) else println(deque.first())
            }

            "back" -> {
                if (deque.isEmpty()) println(-1) else println(deque.last())
            }
        }
    }
}