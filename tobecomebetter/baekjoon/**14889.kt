package com.kguard.tobecomebetter.baekjoon

import kotlin.math.*
import kotlin.system.exitProcess
//실버 1
private var startLink = mutableListOf<MutableList<Int>>()
private var visited = mutableListOf<Boolean>()
private var n = 0
private var result = Integer.MAX_VALUE
fun main() {
    n = readln().toInt()
    visited = MutableList(n) { false }
    repeat(n)
    {
        startLink.add(readln().split(" ").map { it.toInt() }.toMutableList())
    }
    dfs(0, 0)
    print(result)
}

private fun dfs(index: Int, depth: Int) { // depth는 카운트 수, index는 다음 값
    if (depth == n / 2) {
        diff();
        return;
    }
    for (i in index until n) {
        if (visited[i])  // 팀을 나눠야 하는거니 1차원 배열로 접근
            continue
        visited[i] = true;
        dfs(i + 1, depth + 1);
        visited[i] = false;
    }
}

private fun diff() {
    var teamStart = 0
    var teamLink = 0
    for (i in 0 until n - 1) {
        for (j in i + 1 until n) {
            if (visited[i] && visited[j]) teamStart += startLink[i][j] + startLink[j][i]
            else if (!visited[i] && !visited[j]) teamLink += startLink[i][j] + startLink[j][i]
        }
    }
    val dif = abs(teamStart - teamLink)
    result = min(result, dif)

    if (result == 0) {
        println(result)
        exitProcess(0);
    }
}