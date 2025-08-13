package com.kguard.tobecomebetter.baekjoon

fun main() {
    readln()
    val list = readln().split(" ").map { it.toInt() }.toMutableList()
    val num = readln().toInt()
    print(list.count { it == num })
}