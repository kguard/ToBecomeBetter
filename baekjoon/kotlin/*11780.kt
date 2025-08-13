package com.kguard.tobecomebetter.baekjoon

// 골드 2 플로이드 2
// 그래프 이론, 최단 경로, 플로이드–워셜(dp)
// 플로이드 워셜 11404 번과 같은 방식으로 문제 해결
// 3차원 배열 check를 만들어서 거쳐가는 모든 노드를 저장 해 놓음
fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val graph = MutableList(n + 1) { MutableList(n + 1) { 10000000 } } // 도시 최대 개수 * 가중치 최대 값 -> 최소거리를 저장하는 곳
    val check = MutableList(n + 1) { MutableList(n + 1) { mutableListOf<Int>() } } // 3차원 배열 -> 거쳐가는 모든 노드를 저장하는 곳
    repeat(m) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        if (graph[a][b] > c)
            graph[a][b] = c
    }
    repeat(n + 1) {
        graph[it][it] = 0
    }
    for (a in 1..n)
        for (b in 1..n)
            check[a][b].add(a) // 출발지 추가
    // 플로이드-워셜 알고리즘
    for (i in 1..n) // i 번째 노드를 거처서 가는 경우
        for (a in 1..n) // a 번째 노드에서 시작하고
            for (b in 1..n) {// b 번째 노드에 도착하는 경우
                if (a == b) continue
                if (graph[a][b] > graph[a][i] + graph[i][b]) // a에서 b로 가는 기존에 저장되어 있는 최소 거리가 i번째 노드를 거쳐서 가는 경우보다 큰 경우
                {
                    graph[a][b] = graph[a][i] + graph[i][b]
                    check[a][b] = (check[a][i] + check[i][b]).toMutableList() // 기존에 최소 거리로 거쳐가는 모든 부분을 저장해야되기 때문에 저장
                }
            }
    for (a in 1..n)
        for (b in 1..n)
            check[a][b].add(b) // 도착지 추가

    for (i in 1..n) {
        for (j in 1..n) {
            if (graph[i][j] >= 10000000)
                print("0 ")
            else
                print("${graph[i][j]} ")
        }
        println()
    }
    for (a in 1..n) // 모든 경유 노드를 출력하는 부분
        for (b in 1..n) {
            if (a == b) { // 같은 곳은 못감
                println(0)
            } else if (graph[a][b] >= 10000000) { // 도달할 수 없는 곳일때
                println(0)
            } else {
                print("${check[a][b].size} ") // 크기와
                for (t in check[a][b]) // 거쳐가는 모든 부분 출력
                    print("$t ")
                println()
            }
        }
}