package com.kguard.tobecomebetter.baekjoon

import kotlin.math.abs

// 브론즈 5 사파리월드
// 수학, 구현, 사칙연산
fun main(){
    val (n,m) = readln().split(" ").map { it.toLong() }
    println(abs(n-m))
}