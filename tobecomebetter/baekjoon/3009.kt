package com.kguard.tobecomebetter.baekjoon

fun main() {
    val x = mutableListOf<Int>()
    val y = mutableListOf<Int>()
    repeat(3)
    {
        val a = readln().split(" ").map { it.toInt() }
        x.add(a[0])
        y.add(a[1])
    }
    val tx = x.toMutableSet().sum() * 2 - x.sum()
    val ty = y.toMutableSet().sum() * 2 - y.sum()
    print("$tx $ty")
}