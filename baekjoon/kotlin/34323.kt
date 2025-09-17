package com.kguard.tobecomebetter.baekjoon.kotlin

fun main(){
    val (n,m,v) = readln().split(" ").map { it.toLong() }
    val sum = (m+1) * v
    val a = sum * (100-n) / 100
    val b = m * v
    println(if(a>b) b else a)
}