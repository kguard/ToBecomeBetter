package com.kguard.tobecomebetter.baekjoon

// 실버 5
// 수학, 구현
// 행렬 곱셉에 대한 이해가 필요함
// nxm 행렬과 mxk의 행렬을 곱하면 nxk의 행렬이 생성됨
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val a = mutableListOf<MutableList<Int>>()
    repeat(n) {
        a.add(readln().split(" ").map { it.toInt() }.toMutableList())
    }
    val b = mutableListOf<MutableList<Int>>()
    val (m1, k) = readln().split(" ").map { it.toInt() }
    repeat(m) {
        b.add(readln().split(" ").map { it.toInt() }.toMutableList())
    }
    val c = MutableList(n) { MutableList(k) { 0 } }
    for (i in 0 until n)
        for (j in 0 until k)
            for (t in 0 until m)
                c[i][j] += a[i][t] * b[t][j]
    for (i in c) {
        for (j in i)
            print("$j ")
        println()
    }
}