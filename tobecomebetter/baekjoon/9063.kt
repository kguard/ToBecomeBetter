package com.kguard.tobecomebetter.baekjoon

fun main() {
    val repeat = readln().toInt()
    val x = mutableListOf<Int>()
    val y = mutableListOf<Int>()
    repeat(repeat)
    {
        val a = readln().split(" ").map { it.toInt() }
        x.add(a[0])
        y.add(a[1])
    }
    val width = x.max() - x.min()
    val height = y.max() - y.min()
    print(width * height)
}