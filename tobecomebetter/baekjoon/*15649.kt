package com.kguard.tobecomebetter.baekjoon

//실버 3
// 1 -> 2, 3, 4
// 2 -> 1, 3, 4
// 3 -> 1, 2, 4,
// 4 -> 1, 2, 3 으로 진행
private var arr = mutableListOf<Int>()
private var visited = mutableListOf<Boolean>()
private var n = 0
private var m = 0
fun main() {
    val a = readln().split(" ").map { it.toInt() }
    n = a[0]
    m = a[1]
    arr = MutableList(m) { 0 }
    visited = MutableList(n) { false }
    dfs(0)
}

private fun dfs(len: Int) {
    if (len == m) {
        arr.forEach { print("$it ") }
        println()
        return
    }
    for (i in 0 until n) {
        if (!visited[i]) {
            visited[i] = true
            arr[len] = i + 1
            dfs(len + 1)
            visited[i] = false
        }
    }
}