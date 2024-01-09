package com.kguard.tobecomebetter.baekjoon

fun main() {
    val a = readln().split(" ").map { it.toInt() }
    val b = readln().split(" ").map { it.toInt() }
    val n = mutableListOf(a[1],b[1]).sorted()
    var a1 = n[0]
    var b1 = n[1]
    while (a1 % b1 != 0) {
        val x = b1
        b1 = a1 % b1
        a1 = x
    }
    val bottom = a[1]*b[1] / b1
    val top = (bottom/a[1])*a[0] + (bottom/b[1])*b[0]
    var top1 = top
    var bottom1 = bottom
    while (bottom1 % top1 != 0) {
        val x = top1
        top1 = bottom1 % top1
        bottom1 = x
    }
    println("${top/top1} ${bottom/top1}")
}