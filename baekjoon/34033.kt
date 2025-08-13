package com.kguard.tobecomebetter.baekjoon

// 실버 4 공금 횡령
// 자료구조, 집합과 맵
fun main() {
    val map = HashMap<String, Double>()
    val (n, m) = readln().split(" ").map { it.toInt() }
    var count = 0
    repeat(n) {
        val (name, price) = readln().split(" ")
        map[name] = price.toDouble()
    }
    repeat(m) {
        val (name, price) = readln().split(" ")
        map[name]?.let { it -> if (it * 1.05 < price.toDouble()) count++ }
    }
    println(count)
}