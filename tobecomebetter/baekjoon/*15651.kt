package com.kguard.tobecomebetter.baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

//실버 3
// 1 -> 2, 3, 4
// 2 -> 1, 3, 4
// 3 -> 1, 2, 4,
// 4 -> 1, 2, 3 으로 진행
private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))
private var arr = mutableListOf<Int>()
private var visited = mutableListOf<Boolean>()
private var n = 0
private var m = 0
fun main() {
    val a = br.readLine().split(" ").map { it.toInt() }
    n = a[0]
    m = a[1]
    arr = MutableList(m) { 0 }
    visited = MutableList(n) { false }
    dfs(0)
    bw.flush()
    bw.close()
}

private fun dfs(len: Int) {
    if (len == m) {
        arr.forEach { bw.write("$it ") }
        bw.write("\n")
        return
    }
    for (i in 0 until n) {
        if (!visited[i]) {
            arr[len] = i + 1
            dfs(len + 1)
        }
    }
}