package com.kguard.tobecomebetter.baekjoon

// 브론즈 5 피갤컵
// 수학, 구현, 사칙연산
fun main(){
    var year = 2024
    var month = 8
    val n = readln().toInt() * 7 - 7
    year += n / 12
    month += n % 12
    if(month > 12) {
        month -= 12
        year++
    }
    print("$year $month")
}