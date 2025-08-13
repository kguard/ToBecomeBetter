package com.kguard.tobecomebetter.baekjoon

fun main() {
    val a = readln().split(" ").map { it.toInt() }
    val t = mutableListOf<Int>()
    for (i in 1..a[0]) {
        if (a[0] % i == 0)
            t.add(i)
        if (t.size == a[1])
            break
    }
    if (t.size < a[1])
        println(0)
    else
        println(t.last())
}