package com.kguard.tobecomebetter.baekjoon

// 브론즈 4 SciComLove (2025)
// 구현, 문자열
fun main() {
    val c = "SciComLove"
    val t = readln()
    var count = 0
    for (i in c.indices) {
        if (c[i] != t[i]) count++
    }
    println(count)
}