package com.kguard.tobecomebetter.baekjoon

// 브론즈 4 별 찍기 - 3
// 구현
fun main(){
    val n = readln().toInt()
    for(i in n downTo 1){
        repeat(i){
            print("*")
        }
        println()
    }
}