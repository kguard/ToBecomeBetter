package com.kguard.tobecomebetter.baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.pow


// 플래티넘 5 LCA 2
// 자료 구조, 트리, 최소 공통 조상, 희소 배열
// 17435번에서 썼던 sparse_table을 사용해서 문제 풀어야됨.
// 1. 더 깊이 있는 노드의 위치를 같은 위치로 끌어올리기
// 2. 두개의 노드가 같아 질때 까지 부모노드로 이동
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val k = 17 // 2^17=131,072, n의 최대 값이 100,000 이기 때문에 k를 17로 잡음

    val parent = Array(k + 1) { Array(n + 1) { 0 } } // y축은 2진수 표현, x축은 각각의 부모
    val graph = Array(n + 1) { mutableSetOf<Int>() } // 두 노드의 연관성을 넣기 위한 그래프
    val depth = Array(n + 1) { 0 } // 각 노드의 깊이를 저장할 리스트

    repeat(n - 1) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    fun dfs(node: Int, cur: Int) { // 입력된 두개의 수 중 부모를 찾기 위한 함수
        depth[node] = cur // 깊이를 저장
        for (next in graph[node]) // 연결되는 노드들
            if (depth[next] == 0) { // 깊이가 0이면
                dfs(next, cur + 1) // 깊이 추가
                parent[0][next] = node // 부모추가
            }
    }
    dfs(1, 1)

    for (i in 1..k) // 부모를 채우기 위한 반복문
        for (j in 1..n)
            parent[i][j] = parent[i - 1][parent[i - 1][j]]

    fun lca(a: Int, b: Int): Int { // LCA를 이용해서 최소 공통 부모 찾기
        var a1 = a
        var b1 = b
        if (depth[a1] < depth[b1]) { // a가 더 깊은 깊이로 만들기
            val tmp = a1
            a1 = b1
            b1 = tmp
        }

        for (i in k downTo 0) // 1. 더 깊이 있는 노드의 위치를 같은 위치로 끌어올리기 위한 작업
            if (2.0.pow(i).toInt() <= depth[a1] - depth[b1]) // 길이의 차이는 계속 바뀌기 때문에 주의!!!
                a1 = parent[i][a1]

        if (a1 == b1) return a1

        for (i in k downTo 0) { // 2. 두개의 노드가 같아 질때 까지 부모노드로 이동
            if (parent[i][a1] != parent[i][b1]) {
                a1 = parent[i][a1]
                b1 = parent[i][b1]
            }
        }
        return parent[0][a1]
    }

    val m = br.readLine().toInt()
    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        bw.write("${lca(a, b)}\n")
    }
    bw.flush()
    bw.close()
}
