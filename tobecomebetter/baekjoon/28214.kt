package com.kguard.tobecomebetter.baekjoon

// 브론즈 3 크림빵
// 구현
fun main() {
    val (n, k, p) = readln().split(" ").map { it.toInt() }
    val bread = readln().split(" ").map { it.toInt() }
    var count = 0
    for (i in 0..n * k - k step k)
        if (bread.slice(i..i + k - 1).count { it == 0 } < p)
            count++
    print(count)
}