package com.kguard.tobecomebetter.baekjoon

// 브론즈 4 세수정렬
// 구현, 정렬
fun main(){
    val a = readln().split(" ").map { it.toInt() }
    for(i in a.sorted())
        print("$i ")
}