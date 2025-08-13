package com.kguard.tobecomebetter.baekjoon

import java.math.BigInteger

//실버 5
// 겹치면 안되기 때문에 순서에 맞는거 하나만 고르면 된다. 따라서 mCn 으로 계산. (n<m)
fun main() {
    val rep = readln().toInt()
    repeat(rep)
    {
        val n = readln().split(" ").map { it.toInt() }
        println(combination(n[1], n[0]))
    }
}

private fun combination(n: Int, r: Int): Long {
    var t: Int = r
    var div: Long = 1 // 분모
    var result: Long = 1
    if (r > n / 2)
        t = n - r
    for (i in 1..t)
        div *= i
    for (i in n - t + 1..n) {
        result *= i // 분경 먼저 곱하기
        if (result >= div && (result % div).toInt() == 0) // 곱한 값들이 분모 보다 크고, 분모로 나눠질 경우에
        {
            result /= div
            div = 1 // 한번만 나눠져야 하기 때문에 1로 변
        }
    }
    return result
}