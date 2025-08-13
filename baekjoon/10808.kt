package com.kguard.tobecomebetter.baekjoon

// 브론즈 4 알파벳 개수
// 구현, 문자열
fun main() {
    val n = readln()
    val list = MutableList(26) { 0 }
    n.forEach { list[it.code-97]++ }
    list.forEach { print("$it ") }
}