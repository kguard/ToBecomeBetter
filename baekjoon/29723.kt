package com.kguard.tobecomebetter.baekjoon

// 실버 5 브실이의 입시전략
// 자료 구조, 정렬, 해시를 사용한 집합과 맵
// Pair로 해결
fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    var sub = mutableListOf<Pair<String, Int>>()
    repeat(n) {
        val (a, b) = readln().split(" ")
        sub += a to b.toInt()
    }
    sub.sortBy { it.second }
    var min = 0
    var max = 0
    repeat(k) {
        val s = readln()
        min += sub.find { it.first == s }!!.second
        max += sub.find { it.first == s }!!.second
        sub.remove(sub.find { it.first == s }!!)
    }
    val d = m - k
    for (i in 0 until d) {
        min += sub[i].second
        max += sub[sub.size - 1 - i].second
    }
    println("$min $max")
}