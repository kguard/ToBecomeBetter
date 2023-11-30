package com.kguard.tobecomebetter.baekjoon

fun main() {
    val price = readln().toInt()
    val count = readln().toInt()
    var sum = 0
    for (i in 0 until count) {
        val a = readln().split(" ").map { it.toInt() }
        sum += (a[0] * a[1])
    }
    if (price == sum)
        print("Yes")
    else
        print("No")
}