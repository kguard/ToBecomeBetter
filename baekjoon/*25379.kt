package com.kguard.tobecomebetter.baekjoon

import kotlin.math.min

// 실버 4 피하자
// 그리디 알고리즘
// 짝수와 홀수가 양쪽에 몰려있어야 한다는 점은 알음, 왼쪽 오른쪽 경우의 수가 2가지 인것도 알았음
// 하지만 구현 방법을 생각 못함
// 왼쪽에 짝수를 둘때는 홀수인 경우를 하나씩 세며, 짝수가 나왔을 때 그 수들을 교환하도록 evenCount에 더함
// 왼쪽에 홀수를 둘때는 짝수인 경우를 하나씩 세며, 홀수가 나왔을 때 그 수들을 교환하도록 oddCount에 더함
fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    var odd = 0L // 홀수를 세기 위한 수 (왼쪽이 짝수일 떄 사용함)
    var oddLeft = 0L // 왼쪽이 홀수일 떄 교환한 수
    var even = 0L // 짝수를 세기 위한 수 (왼쪽이 홀수일 떄 사용함)
    var evenLeft = 0L // 왼쪽이 짝수일 떄 교환한 수
    for (i in list) {
        if (i % 2 == 1) { // 홀수일 경우
            odd++ // 홀수의 갯수가 증가 (왼쪽이 짝수일 경우에 사용)
            oddLeft += even // 왼쪽이 홀수인 경우는 교환해야하는 짝수 수 더해주기
        } else {
            even++ // 짝수의 갯수 증가
            evenLeft += odd // 왼쪽이 짝수인 경우는 교환해야하는 홀수 수 더해주기
        }
    }
    print(min(evenLeft, oddLeft))
}