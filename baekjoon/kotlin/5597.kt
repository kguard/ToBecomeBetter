package com.kguard.tobecomebetter.baekjoon

fun main() {
    val t = (1..30).toMutableList()
    repeat(28)
    {
        t.remove(readln().toInt())
    }
    for (i in t)
        println(i)
}