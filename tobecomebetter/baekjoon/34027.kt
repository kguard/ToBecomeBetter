package com.kguard.tobecomebetter.baekjoon

import kotlin.math.*

// 브론즈 3 제곱 수?
// 수학, 구현, 사칙연산
// 수를 그 제곱근으로 나누었을 때, 몫은 제곱근이고, 나머지는 0이어야 됨
fun main(){
    repeat(readln().toInt()){
        val n = readln().toInt()
        if(n % sqrt(n.toDouble()) == 0.0 && n / sqrt(n.toDouble()) == sqrt(n.toDouble())) // n % n의 제곱근이 0 이고, n / n의 제곱근 == n의 제곱근 이어야 됨. 둘다 만족 해야 됨
            println(1)
        else
            println(0)
    }
}