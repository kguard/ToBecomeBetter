package com.kguard.tobecomebetter.baekjoon

// 0 3 5 9 17 33
//    2 4 8 16
// 2의 1승 + 그 전값
// 2의 0승 + 그 전값 = 1+
import kotlin.math.pow

fun main() {
    val count = readln().toInt()
    var a = 2.0
    for (i in 0 until count) {
        a += 2.0.pow(i)
    }
    println(a.pow(2).toInt())
}