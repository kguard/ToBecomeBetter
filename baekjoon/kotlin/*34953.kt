package com.kguard.tobecomebetter.baekjoon.kotlin

// 실버 5 SSHS 문자열
// 단순 구현 문제인거 같음
// SSH"S" 가 반복 되기 때문에 SSH 만 최소로 반복되는 것이 최대가 나을 거같음
fun main(){
    val n = readln().toInt()
    val origin = "SSH"
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    val bw = BufferedWriter(OutputStreamWriter(System.out))
    println(origin.repeat((n/origin.length) + 1).take(n))
}