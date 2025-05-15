package com.kguard.tobecomebetter.baekjoon

// 브론즈 2 막대기
// 구현, 자료 구조, 스택
fun main() {
    val n = readln().toInt()
    val h = mutableListOf<Int>()
    repeat(n) { h.add(readln().toInt()) }
    var count = 1
    var best = h.last()
    for (i in n - 2 downTo 0)
        if (h[i] > best) {
            count++
            best = h[i]
        }
    print(count)
}