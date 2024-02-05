package com.kguard.tobecomebetter.baekjoon

fun main(){
    readln()
    val n = readln().split(" ").map { it.toInt() }.sorted()
    print(n.first()*n.last())
}