package com.kguard.tobecomebetter.baekjoon

// 브론즈 3 PNUPC에 한 번도 빠지지 않고 출연한 산지니가 새삼 대단하다고 느껴지네
// 문자열
fun main(){
    val s = readln()
    val t = readln()
    for(i in t){
       if(i !in s)
           print(i)
    }
}