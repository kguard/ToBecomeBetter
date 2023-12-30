package com.kguard.tobecomebetter.baekjoon

fun main(){
    val n = readln().split(" ").map { it.toInt() }
    val map = mutableSetOf<String>()
    var count = 0
    repeat(n[0]){
        map.add(readln())
    }
    repeat(n[1])
    {
        if(readln() in map)
            count++
    }
    print(count)
}