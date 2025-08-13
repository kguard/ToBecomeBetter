package com.kguard.tobecomebetter.baekjoon

// 브론즈 4 구멍
// 수학, 문자열
fun main() {
    val upper = arrayOf(1, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0)
    val lower = arrayOf(1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    val s = readln().replace(" ", "")
    var hole = 0
    for (i in s.indices) {
        if (s[i] == '@')
            hole++
        else if (s[i].isUpperCase())
            hole += upper[s[i].code - 65]
        else if (s[i].isLowerCase())
            hole += lower[s[i].code - 97]
    }
    println(hole)
}