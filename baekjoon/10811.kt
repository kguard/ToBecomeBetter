package com.kguard.tobecomebetter.baekjoon

fun main() {
    val nm = readln().split(" ").map { it.toInt() }
    val n = nm[0]
    val m = nm[1]
    var basket = (1..n).toMutableList()
    repeat(m)
    {
        val j = readln().split(" ").map { it.toInt() }
        val slice = basket.slice(j[0] - 1..<j[1]).reversed().toMutableList()
        for (i in j[0] - 1..<j[1])
            basket[i] = slice[i - (j[0] - 1)]
    }
    for (i in basket)
        print("$i ")
}