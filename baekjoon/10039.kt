package com.kguard.tobecomebetter.baekjoon

// 브론즈 4 평균 점수
// 수학, 사칙연산
fun main() {
    var sum = 0
    repeat(5) {
        sum += readln().toInt().let { if (it < 40) 40 else it }
    }
    print(sum/5)
}