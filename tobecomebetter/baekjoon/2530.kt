package com.kguard.tobecomebetter.baekjoon

// 브론즈 4 인공지능 시계
// 수학, 사칙연산
fun main() {
    var (a, b, c) = readln().split(" ").map { it.toInt() }
    var d = readln().toInt()
    a += d / 3600
    d -= d / 3600 * 3600
    b += d / 60
    d -= d / 60 * 60
    c += d
    if (c >= 60) {
        b += c / 60
        c %= 60
    }
    if (b >= 60) {
        a += b / 60
        b %= 60
    }
    if (a >= 24)
        a %= 24
    print("$a $b $c")
}