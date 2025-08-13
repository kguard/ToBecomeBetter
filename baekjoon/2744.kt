package com.kguard.tobecomebetter.baekjoon

// 브론즈 5 대소문자 바꾸기
// 구현, 문자열
fun main(){
    val n = readln()
    var answer = ""
    for(i in n){
        answer += if(i.isLowerCase()) i.uppercase()
        else i.lowercase()
    }
    println(answer)
}