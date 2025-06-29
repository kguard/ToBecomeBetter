package com.kguard.tobecomebetter.baekjoon

// 브론즈 2 숫자
// 구현
fun main() {
    val (a, b) = readln().split(" ").map { it.toLong() }.sorted()
    if (a == b)
        println(0)
    else {
        println(b - a - 1)
        for (i in a + 1 until b)
            print("$i ")
    }
}