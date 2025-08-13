package com.kguard.tobecomebetter.baekjoon

// 브론즈 2 음계
// 구현
fun main(){
    val list = readln().split(" ").map { it.toInt() }
    when (list) {
        list.sorted() -> println("ascending")
        list.sortedDescending() -> println("descending")
        else -> println("mixed")
    }
}