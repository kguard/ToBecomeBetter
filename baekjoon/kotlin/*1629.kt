package com.kguard.tobecomebetter.baekjoon

// 실버 1
// 수학, 분할 정복을 이용한 거듭제곱
// 모듈러 성질 : (a*b)%c = (a%c * b%c)%c
// 지수 밥칙 : a^(n+m) = a^n * a^m
// 지수 법칙과 모듈러 성질을 사용해서 문제 풀기
fun main() {
    val (a, b, c) = readln().split(" ").map { it.toLong() }
    println(mul(a, b, c))
}

private fun mul(a: Long, b: Long, c: Long): Long {
    if (b == 1L) return a % c // 지수가 1일 때는 단순히 나머지 연산
    val k = mul(a, b / 2, c) % c // 지수를 2로 나누어서 두개로 계산
    return if (b % 2 == 0L) k * k % c // 지수가 짝수일 경우에는 나눈 두 수를 곱한 다음 나머지 연산
    else k * k % c * a % c // 지수가 홀수일 경우에는 나눈 두 수를 곱한 다음 나머지 연산하고, 하나 더 계산
}