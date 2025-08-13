package com.kguard.tobecomebetter.baekjoon

fun main() {
    val a = readln().split(" ").map { it.toInt() }
    var x = a[2] - a[0]
    var y = a[3] - a[1]
    if (x > a[0])
        x = a[0]
    if (y > a[1])
        y = a[1]
    if (x > y)
        println(y)
    else
        print(x)
}