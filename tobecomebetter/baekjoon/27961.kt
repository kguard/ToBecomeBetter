package com.kguard.tobecomebetter.baekjoon

import kotlin.math.*

// 브론즈 1 고양이는 많을수록 좋다
// 수학, 그리디 알고리즘 -> 최적의 수를 사용해서 문제 해결
// log2를 사용해서 횟수를 구할 수 있음
fun main() {
    val n = readln().toLong()
    val a = String.format("%.10f", log2(n.toDouble())) // log2를 소수점 10번째 자리 까지만 표현하기 위함
    println(if(n == 0L) 0 else ceil(a.toDouble()).toInt()+1) // 주어진 수를 log2를 한다음 올림을 한 숫자에서 +1 하면됨

//    var count = 0 // 단순히 기본숫자에 *2를 진행하며 count를 세는 방법
//    if (n == 0L)
//        println(count)
//    else {
//        var a = 1
//        while (a < n) {
//            a *= 2
//            count += 1
//        }
//        println(count)
//    }
}