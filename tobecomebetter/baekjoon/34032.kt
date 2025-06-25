package com.kguard.tobecomebetter.baekjoon

// 브론즈 4 /gg
fun main(){
    val n = readln().toDouble()
    val s = readln()
    if(s.count { it == 'O' } >= n/2) println("Yes") else println("No")
}