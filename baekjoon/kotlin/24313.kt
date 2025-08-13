package com.kguard.tobecomebetter.baekjoon

fun main() {
    val n = readln().split(" ").map { it.toInt() }
    val c = readln().toInt()
    val nz = readln().toInt()
    if (n[0] * nz + n[1] <= nz * c && n[0] <= c) //n[1]번째 상수가 음수일 경우에는 nz보다 큰 수여도 만족을 안할 수 있기 때문에 두번째 비교문이 필요하다.
        println(1)
    else
        print(0)
}