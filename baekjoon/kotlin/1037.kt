package com.kguard.tobecomebetter.baekjoon
//브론즈 1
fun main(){
    readln()
    val n = readln().split(" ").map { it.toInt() }.sorted()
    print(n.first()*n.last())
}