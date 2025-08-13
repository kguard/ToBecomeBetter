package com.kguard.tobecomebetter.baekjoon

// 브론즈 3 세 수
// 구현, 정렬
fun main(){
    val list = readln().split(" ").map { it.toInt() }.sorted()
    println(list[1])
}