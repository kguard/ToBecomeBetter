package com.kguard.tobecomebetter.baekjoon

import java.util.PriorityQueue

// 골드 2 문제집
// 자료 구조, 그래프 이론, 우선순위 큐, 위상 정렬, 방향 비순환 그래프
// 2252번과 풀이과정 동일
// 2252번 위상정렬 문제와 같은 방식으로 문제 해결, 위상정렬로 문제 해결
// 큐 부분에 우선순위 큐를 적용시켜 가능한 앞에 있는 문제를 풀도록 함
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = MutableList(n + 1) { mutableListOf<Int>() } // 그래프를 그리기 위한 리스트
    val inDegree = MutableList(n + 1) { 0 } // 진입차수(인덱스로 들어오는 간선의 갯수)
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b) // 특정 노드에 대한 간선을 추가 함
        inDegree[b] += 1 // b에 대한 진입차수를 하나 증가 시킴
    }
    val queue = PriorityQueue<Int>() // 우선 순위 큐를 적용시켜 앞에 있는 문제를 풀도록 함
    val result = mutableListOf<Int>()
    for (i in 1..n)
        if (inDegree[i] == 0) // 진입차수가 0인 문제들은 먼저 풀도록 함
            queue.add(i) // 먼저 풀 문제들 큐에 삽입
    while (queue.isNotEmpty()) {
        val poll = queue.poll() // 맨 앞에 있는 거 poll
        result.add(poll) // result에 poll 저장
        for (i in graph[poll]) { // poll에서 연결되어 있는 노드에서
            inDegree[i] -= 1 // poll을 result에 저장했으니 진입차수 -1함
            if (inDegree[i] == 0) // 진입차수가 0이 되면
                queue.add(i)// queue에 노드 추가
        }
    }
    result.forEach { print("$it ") }
}