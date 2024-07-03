package com.kguard.tobecomebetter.baekjoon

// 골드 4 플로이드
// 그래프 이론, 최단 경로, 플로이드–워셜(dp)
// 플로이드 워셜은 모든 지점에서 다른 모든 지점까지의 최소 거리를 구하는 알고리즘. 시간복잡도가 오래 걸림
// 2차원 배열을 통해서 모든 최소 거리를 저장
// 다른 모든 노드를 거쳐 가는 과정을 반복해서 기존에 저장된 최소 거리와 비교해서 최소 거리 구하기
fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val graph = MutableList(n + 1) { MutableList(n + 1) { 10000000 } } // 도시 최대 개수 * 가중치 최대 값
    repeat(m) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        if (graph[a][b] > c)
            graph[a][b] = c
    }
    repeat(n + 1) {
        graph[it][it] = 0
    }
    // 플로이드-워셜 알고리즘
    for (i in 1..n) // i 번째 노드를 거처서 가는 경우
        for (a in 1..n) // a 번째 노드에서 시작하고
            for (b in 1..n)// b 번째 노드에 도착하는 경우
                if (graph[a][b] > graph[a][i] + graph[i][b]) // a에서 b로 가는 기존에 저장되어 있는 최소 거리가 i번째 노드를 거쳐서 가는 경우보다 큰 경우
                    graph[a][b] = graph[a][i] + graph[i][b]
    for(i in 1 .. n) {
        for (j in 1..n){
            if(graph[i][j] >= 10000000)
                print("0 ")
            else
                print("${graph[i][j]} ")
        }
        println()
    }
}