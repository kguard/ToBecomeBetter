package com.kguard.tobecomebetter.baekjoon

// 브론즈 4 Practice: Roll Call
// 구현
fun main(){
    repeat(readln().toInt()){
        val secondName = readln()
        val firstName = readln()
        println("Case ${it + 1}: $firstName, $secondName")
    }
}