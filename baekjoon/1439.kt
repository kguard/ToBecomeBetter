package com.kguard.tobecomebetter.baekjoon

import kotlin.math.min

// 실버 5 뒤집기
// 그리디 알고리즘, 문자열
fun main() {
    val string = readln()
    val count0 = string.split('1').filter { "0" in it }.size
    val count1 = string.split('0').filter { "1" in it }.size
    print(min(count0, count1))
}

