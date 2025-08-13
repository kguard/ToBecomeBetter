package com.kguard.tobecomebetter.baekjoon

// 브론즈 4 레퓨닛의 덧셈
// 수학, 사칙연산
fun main(){
    val (x,y) = readln().split(" ").map { it.toInt() }
    print("1".repeat(x).toInt() + "1".repeat(y).toInt())
}