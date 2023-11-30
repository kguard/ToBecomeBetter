package com.kguard.tobecomebetter.baekjoon

fun main() {
    val mn = readln().split(" ").map { it.toInt() }
    val n = mn[0]
    val m = mn[1]
    val basket = List<Int>(n) { 0 }.toMutableList()
    for (i in 0 until m) {
        val j = readln().split(" ").map { it.toInt() }
        for (t in j[0] - 1..<j[1])
            basket[t] = j[2]
    }
    for (i in basket)
        print("$i ")
}
