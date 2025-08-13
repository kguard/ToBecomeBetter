package com.kguard.tobecomebetter.baekjoon

// 브론즈 3 윷놀이
// 구현
fun main() {
    repeat(3) {
        val y = readln().split(" ").map { it.toInt() }
        when (y.count { it == 0 }) {
            0 -> println("E")
            1 -> println("A")
            2 -> println("B")
            3 -> println("C")
            4 -> println("D")
        }
    }
}