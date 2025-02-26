package com.kguard.tobecomebetter.baekjoon

import kotlin.math.min

// 브론즈 5 노트북 세 대를 가지고 왔다
// 수학, 구현
fun main(){
    val (n,m) = readln().split(" ").map { it.toInt() }
    println(min(n,m))
}