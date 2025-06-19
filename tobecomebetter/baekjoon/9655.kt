package com.kguard.tobecomebetter.baekjoon

// 실버 5 돌 게임
// 수학, 다이나믹 프로그래밍, 게임 이론
// 단순 규칙 찾기
fun main(){
    val n = readln().toInt()
    if(n % 2 == 0)
        println("CY")
    else
        println("SK")
}

//fun main() { println(if (readln().toInt() % 2 == 0) "CY" else "SK") }