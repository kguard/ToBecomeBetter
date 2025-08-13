package com.kguard.tobecomebetter.baekjoon

// 브론즈 3 어게인 포닉스
// 구현, 문자열
fun main() {
    val t = readln().toInt()
    repeat(t) { println(readln().replace("PO", "PHO")) }
}