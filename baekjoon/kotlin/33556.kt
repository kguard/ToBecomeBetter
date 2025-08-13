package com.kguard.tobecomebetter.baekjoon

// 브론즈 1 Java String Equals
// 구현, 문자열
fun main() {
    val a = readln()
    var b : String? = readln()
    if(b == "null") b = null
    if (a == "null") {
        println("NullPointerException")
        println("NullPointerException")
    } else {
        println(a == b)
        println(a.equals(b, ignoreCase = true))
    }
}