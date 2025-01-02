package com.kguard.tobecomebetter.baekjoon

// 브론즈 4 A+B-C
// 수학, 문자열, 사칙연산
fun main(){
    val a = readln()
    val b = readln()
    val c = readln()
    println(a.toInt()+b.toInt()-c.toInt())
    println((a+b).toInt()-c.toInt())
}