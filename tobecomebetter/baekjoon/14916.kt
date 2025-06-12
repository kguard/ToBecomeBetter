package com.kguard.tobecomebetter.baekjoon

// 실버 5 거스름돈
// 수학, 다이나믹 프로그래밍, 그리디 알고리즘
// 굳이 dp로 안 푸는게 나은 듯
fun main() {
    var n = readln().toInt()
    if (n % 5 == 0)
        println(n / 5)
    else if (n < 5) {
        if (n % 2 == 1)
            println(-1)
        else
            println(n / 2)
    } else {
        var count = 0
        count += if ((n % 5) % 2 == 1)
            n / 5 - 1
        else
            n / 5

        n = n - count * 5
        count += n / 2

        println(count)
    }
}