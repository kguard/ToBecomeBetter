package com.kguard.tobecomebetter.baekjoon

// 실버 3 피보나치 함수
// 다이나믹 프로그래밍
// 피보나치 수열에서 0의 갯수와 1의 갯수를 출력하는 문제
// 피보나치 수열의 특징 n = (n-1) + (n-2) 의 특징을 반열
// 0의 갯수를 저장하는 배열과 1의 갯수를 저장하는 배열을 설정 -> DP(다이나믹 프로그래밍) 방식으로 문제 해결
// 점화식 :  n = (n-1) + (n-2)
fun main() {
    val zero = MutableList(41) { 0 } // 문제에서 40 까지이기 떄문에 41로 설정
    val one = MutableList(41) { 0 } // 문제에서 40 까지이기 떄문에 41로 설정
    zero[0] = 1 // 첫 0의 갯수
    one[1] = 1 // 첫 1의 갯수
    for (i in 2..40) { // 피보나치 수열의 특징 및 점화식 사용
        zero[i] = zero[i - 1] + zero[i - 2]
        one[i] = one[i - 1] + one[i - 2]
    }
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        println("${zero[n]} ${one[n]}")
    }
}