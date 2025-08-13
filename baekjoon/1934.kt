package com.kguard.tobecomebetter.baekjoon

// 유클리드 호제법으로 문제 풀기
fun main() {
    repeat(readln().toInt())
    {
        val n = readln().split(" ").map { it.toInt() }.sorted()
        var a = n[0]
        var b = n[1]
        while (a % b != 0) {
            val x = b
            b = a % b
            a = x
        }
        println(n[0] * n[1] / b)
    }
}