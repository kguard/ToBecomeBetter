package com.kguard.tobecomebetter.baekjoon

// 브론즈 1 나머지와 몫이 같은 수
// 수학
// 나머지는 n을 넘길 수 없음
fun main(){
    val n = readln().toLong()
    var sum = 0L
    for(i in 1 until n)
        sum += n * i + i
    println(sum)
}