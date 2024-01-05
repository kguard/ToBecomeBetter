package com.kguard.tobecomebetter.baekjoon

fun main() {
    val n = readln()
    val t = mutableSetOf<String>()
    for(i in 0..n.length)
        for(j in i+1..n.length)
            t.add(n.substring(i,j))
    println(t.size)
}