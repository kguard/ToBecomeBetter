package com.kguard.tobecomebetter.baekjoon

// 브론즈 5 상근이의 친구들
// 수학, 사칙연산
fun main(){
    while (true){
        val a = readln().split(" ").sumOf { it.toInt() }
        if(a == 0) return
        println(a)
    }
}