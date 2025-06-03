package com.kguard.tobecomebetter.baekjoon

// 브론즈 2 나누기
// 수학, 브루트포스 알고리즘
// for문을 돌려도 되었지만 돌리지 않음
fun main() {
    var n = readln().toLong() / 100 * 100
    val f = readln().toInt()
    val min = if (n % f != 0L)
        ((n / f) + 1) * f % 100
    else
        0
    if (min < 10)
        print("0$min")
    else
        print(min)
}