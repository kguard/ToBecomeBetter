package com.kguard.tobecomebetter.baekjoon

fun main() {
    repeat(readln().toInt())
    {
        val a = readln()
        println("${a.first()}${a.last()}")
    }
}