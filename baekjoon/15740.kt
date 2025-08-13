package com.kguard.tobecomebetter.baekjoon

// 브론즈 5 A+B - 9
// 수학, 사칙연산, 임의 정밀도 / 큰 수 연산
fun main(){
    val (a,b) =readln().split(" ").map { it.toBigInteger() }
    println(a+b)
}