package com.kguard.tobecomebetter.baekjoon

// 브론즈 1 팰린드롬수
// 구현, 문자열
fun main() {
    while (true) {
        val a = readln()
        if (a == "0") return
        if (a == a.reversed()) println("yes") else println("no")
    }
}