package com.kguard.tobecomebetter.baekjoon

// 브론즈 3 친구 친구
// 구현
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val friends = MutableList(n) { 0 }
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        friends[a - 1]++
        friends[b - 1]++
    }
    friends.forEach { println(it) }
}