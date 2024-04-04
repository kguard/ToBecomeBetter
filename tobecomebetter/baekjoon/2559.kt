package com.kguard.tobecomebetter.baekjoon

import kotlin.math.max

fun main() {
    val n = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }
    var s = -10000000
    val sum = mutableListOf<Int>()
    sum.add(0)
    for (i in 0 until n[0])
        sum.add(sum[i] + list[i])
    for(i in n[1] .. n[0])
        s = max(s, sum[i]-sum[i-n[1]])
    println(s)
}