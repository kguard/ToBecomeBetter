package com.kguard.tobecomebetter.baekjoon

// 실버 5 스네이크버드
// 그리디 알고리즘, 정렬
fun main() {
    var (n, l) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }.sorted()
    for (i in list) {
        if (i <= l)
            l++
        else
            break
    }
    println(l)
}