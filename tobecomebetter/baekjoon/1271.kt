package com.kguard.tobecomebetter.baekjoon

// 브론즈 5 엄청난 부자2
// 수학, 사칙연산, 임의 정밀도 / 큰 수 연산
fun main(){
    val (n,m) = readln().split(" ").map { it.toBigInteger() }
    println(n/m)
    println(n%m)
}