package com.kguard.tobecomebetter.baekjoon

// 살버 4 그거 왜 말해!
// 문자열, 애드 혹
// n을 입력 받지 않아서 틀림...
fun main(){
    val n = readln()
    val s = readln()
    if(s.last() == 'A' || s.first() == 'B')
        println("No")
    else
        println("Yes")
}