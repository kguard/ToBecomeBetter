package com.kguard.tobecomebetter.baekjoon

fun main(){
    readln()
    val a = readln().split(" ").toMutableSet()
    val b = readln().split(" ").toMutableSet()
    print(a.subtract(b).size + b.subtract(a).size)
}