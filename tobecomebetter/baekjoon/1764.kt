package com.kguard.tobecomebetter.baekjoon

fun main(){
    val n = readln().split(" ").map { it.toInt() }
    val listen = mutableSetOf<String>()
    val see = mutableSetOf<String>()
    repeat(n[0])
    {
        listen.add(readln())
    }
    repeat(n[1])
    {
        see.add(readln())
    }
    val listenSee = listen.intersect(see)
    println(listenSee.size)
    for(i in listenSee.sorted())
        println(i)
}