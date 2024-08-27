package com.kguard.tobecomebetter.baekjoon

// 골드 5 트리와 쿼리
// 다이나믹 프로그래밍, 그래프 이론, 그래프 탐색, 트리, 깊이 우선 탐색(dfs), 트리에서의 다이나믹 프로그래밍
// dfs, dp의 원리를 사용, 먼가 혼자 조금만 더 생각했으면...
fun main() {
    val (n, r, q) = readln().split(" ").map { it.toInt() }
    val graph = MutableList(n + 1) { mutableListOf<Int>() }
    val visitedDP = MutableList(n + 1) { -1 } // dp의 원리를 사용해서 서브트리의 갯수를 저장
    repeat(n - 1) {
        val (u, v) = readln().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }
    // 문제 힌트에서 알려준 방식으로 해결한 것
//    val child = MutableList(n + 1) { mutableListOf<Int>() }
//    fun makeTree(current: Int, parent: Int) {
//        for (i in graph[current]) {
//            if (i != parent) {
//                child[current].add(i)
//                makeTree(i, current)
//            }
//        }
//    }
//    makeTree(r, -1)
//    fun countSubTree(s: Int) {
//        for (i in child[s]) {
//            countSubTree(i)
//            size[s] += size[i]
//        }
//    }
//    countSubTree(r)
    // dfs를 이용하여서 문제 해결
    fun dfs(s: Int): Int {
        visitedDP[s] = 1
        for (i in graph[s]) {
            if (visitedDP[i] == -1) // 방문했는지를 아는 방법
                visitedDP[s] += dfs(i)
        }
        return visitedDP[s]
    }
    dfs(r)
//    println(size)
    repeat(q) {
        println(visitedDP[readln().toInt()])
    }
}