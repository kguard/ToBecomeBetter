package com.kguard.tobecomebetter.baekjoon

// 브론즈 5 체육은 수학과목 입니다 2
// 수학, 구현, 사칙연산
fun main() {
    var sum = 0
    repeat(4) { sum += readln().toInt() }
    if (1800 >= sum + 300) println("Yes") else println("No")
}