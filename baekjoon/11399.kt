package com.kguard.tobecomebetter.baekjoon

// 실버 4
// 그리디 알고리즘
// 누적 합으로 문제를 풀음
fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.toMutableList()
    list.sort()
    val sum = MutableList(n+1) { 0 }
    list.sort()
    for (i in 1 .. n)
        sum[i] = list[i - 1] + sum[i - 1]
    println(sum.sum())
/*    var sum = 0
    var prev = 0
    println(list)
    for(i in 0 until n) {
        sum += prev + list[i]
        prev += list[i]
    }
    println(sum)*/
}