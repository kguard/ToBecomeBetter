package com.kguard.tobecomebetter.baekjoon

//실버 3
// num을 추가하여서 처음 값보다 큰 것만 출력하도록 하여서 중복 제거
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
    dfs(0, 0)
}

private fun dfs(num: Int, len: Int) {
    if (len == m) {
        arr.forEach { print("$it ") }
        println()
        return
    }
    for (i in num until n) {
        if (!visited[i]) {
            visited[i] = true
            arr[len] = i + 1
            dfs(i + 1, len + 1)
            visited[i] = false
        }
    }
}