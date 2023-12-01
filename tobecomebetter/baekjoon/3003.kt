package com.kguard.tobecomebetter.baekjoon

fun main() {
    val chess = mutableListOf<Int>(1, 1, 2, 2, 2, 8)
    val find = readln().split(" ").map { it.toInt() }
    for (i in chess.indices) {
        print("${chess[i] - find[i]} ")
    }
}