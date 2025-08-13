package com.kguard.tobecomebetter.baekjoon

import kotlin.math.max

// 골드 3 ACM Craft
// 다이나믹 프로그래밍, 그래프 이론, 위상 정렬, 방향 비순환 그래프
// 위상 정렬을 이용해서 해결하는 문제
// 2252번의 위상 정렬 알고리즘을 참고해서 문제 해결
// 진입차수를 사용한 위상정렬 문제
// 각 노드들을 dp를 이용해서 저장
// 해당 노드를 완료하려면 연결되어 있는 노드들이 모두 완료 되어야 하기 때문에 연결되어 있는 이전 노드 들중 시간이 제일 많이 걸리는 걸로 선택 (동시에 진행 가능하기 떄문에)
// 진입 차수가 0이 되면 (이전 노드 들이 모두 완료 되었을때) 큐에 추가하여 다음 노드로 진행하도록 함
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (n, k) = readln().split(" ").map { it.toInt() }
        val times = readln().split(" ").map { it.toInt() }
        val graph = MutableList(n + 1) { mutableListOf<Int>() }
        val inDegree = MutableList(n + 1) { 0 } // 진입차수(인덱스로 들어오는 간선의 갯수)
        val dp = MutableList(n + 1) { 0 } // 노드들의 걸리는 시간을 저장하기 위한 리스트
        fun topologySort() {
            val queue = mutableListOf<Int>()
            for (i in 1..n)
                if (inDegree[i] == 0) { // 진입차수가 0인 노드들 큐에 추가
                    queue.add(i)
                    dp[i] = times[i - 1] // 진입차수가 0인 노드들은 시간이 본인 밖에 걸리지 않음
                }
            while (queue.isNotEmpty()) {
                val poll = queue.removeAt(0)
                for (i in graph[poll]) {
                    inDegree[i] -= 1 // 현재 노드는 완료 되었으니 연결되어 있는 다음 노드의 진입차수 -1
                    dp[i] = max(dp[poll] + times[i - 1], dp[i]) // 다음 노드가 걸리는 시간은 (현재 노드가 걸리는 시간 + 다음 노드 자체 걸리는 시간) 과 기존의 다음 노드가 걸리는 시간 중 더 큰값
                    if (inDegree[i] == 0) // 진입 차수가 0인 의미는 다음 노드가 걸리는 시간에 대한 모든 계산이 끝났을 경우
                        queue.add(i) // 모든 계산이 끝났으니 큐에 추가
                }
            }
        }
        repeat(k) {
            val (a, b) = readln().split(" ").map { it.toInt() }
            graph[a].add(b)
            inDegree[b] += 1 // b에 대한 진입차수를 하나 증가 시킴
        }
        val w = readln().toInt()
        topologySort()
        println(dp[w])
    }
}