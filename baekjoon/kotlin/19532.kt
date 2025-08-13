package com.kguard.tobecomebetter.baekjoon

fun main() {
    val n = readln().split(" ").map { it.toInt() }
    val a = n[0]
    val b = n[1]
    val c = n[2]
    val d = n[3]
    val e = n[4]
    val f = n[5]
    val x = ((f*b)-(c*e))/((d*b)-(a*e))
    val y = ((f*a)-(c*d))/((e*a)-(d*b))
    print("$x $y")
}