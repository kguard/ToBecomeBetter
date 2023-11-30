package com.kguard.tobecomebetter.baekjoon

fun main() {
    val mn = readln().split(" ").map { it.toInt() }
    val n = mn[0]
    val m = mn[1]
    val basket = (1..n).toMutableList()
    repeat(m) {
        val j = readln().split(" ").map { it.toInt() }
        var k = 0
        k = basket[j[0] - 1]
        basket[j[0] - 1] = basket[j[1] - 1]
        basket[j[1] - 1] = k
    }
    for (i in basket)
        print("$i ")
}