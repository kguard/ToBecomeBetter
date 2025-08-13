package com.kguard.tobecomebetter.baekjoon

import java.math.BigInteger

// 브론즈5 팩토리얼 3
// 수학, 사칙연산, 임의 정밀도 / 큰 수 연산
// 일반 BigInteger은 해결이 불가능해서 분할정복으로 문제해결
fun main() {
    val n = readln().toInt()
    println(factorial(1, n))
}

private fun factorial(start: Int, end: Int): BigInteger {
    var result = start.toBigInteger()
    if (start < end) { // start 와 end가 같은 경우는 그대로 출력
        val middle = (start + end) / 2 // 숫자의 가운데를 구해서 문제를 해결
        result = factorial(start, middle) * factorial(middle + 1, end)
    }
    return result
}
