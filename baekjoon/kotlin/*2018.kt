package com.kguard.tobecomebetter.baekjoon

// 실버 5 수들의 합 5
// 수학, 두 포인터(투 포인터)
// start와 end를 0으로 설정
// 1. sum <= n 이면 end를 늘리면서 더해서 sum을 키움
// 2. sum > n 이 되면 start를 늘려가며 sum을 줄어줌
// 매번 sum == n 이면 카운트 증가
fun main() {
    val n = readln().toInt()
    var start = 0
    var end = 0
    var count = 0
    var sum = 0
    while (start <= n) {
        if (sum == n)
            count++
        if (sum <= n) {
            end++
            sum += end
        } else {
            start++
            sum -= start
        }
    }
    println(count)
}